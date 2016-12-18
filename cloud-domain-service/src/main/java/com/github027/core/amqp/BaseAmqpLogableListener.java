package com.github027.core.amqp;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.model.SysQueueLog;
import com.github027.domain.model.enums.SysQueueLogStatus;
import com.github027.util._Exp;
import com.github027.util._Sys;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseAmqpLogableListener<T extends BaseAmqpDto> {

	@Autowired
	private SysQueueLogDao sysQueueLogDao;


	/**
	 * Implement this method need add @RabbitListener(queues = QUEUE_NAME)
	 * and need call method handleMessage that support SysQueueLog logging
	 * behavior.
	 */
	protected abstract void receive(final T t);

	public void handleMessage(T t, Consumer<T> consumer) {
		SysQueueLog sysQueueLog = null;
		try {
			sysQueueLog = safeUpdateLogToReceived(t);
			consumer.accept(t);
			safeUpdateLogToSuccess(sysQueueLog);

		} catch (Exception e) {
			log.error(getClass().getName(), e);
			safeUpdateLogToFailure(sysQueueLog, e);

			/*
			 * =============================================================
			 * Queue must consumed no matter have exception or not. If throw
			 * exception here will cause infinite loop.
			 * =============================================================
			 */
		}
	}

	private SysQueueLog safeUpdateLogToReceived(final T t) {
		try {
			final SysQueueLog sysQueueLog = sysQueueLogDao.getJpa().findOne(t.getSysQueueLogId());
			sysQueueLog.initAudit(null);
			sysQueueLog.setStatus(SysQueueLogStatus.R);
			sysQueueLog.setRecvTime(_Sys.now());

			return sysQueueLogDao.getJpa().save(sysQueueLog);

		} catch(Exception e) {
			log.error(getClass().getName(), e);
			return null;
		}
	}

	private void safeUpdateLogToSuccess(final SysQueueLog sysQueueLog) {
		if (sysQueueLog == null) {
			return;
		}

		try {
			sysQueueLog.initAudit(null);
			sysQueueLog.setStatus(SysQueueLogStatus.S);
			sysQueueLog.setFinishTime(_Sys.now());
			sysQueueLogDao.getJpa().save(sysQueueLog);

		} catch(Exception e) {
			log.error(getClass().getName(), e);
		}
	}

	private void safeUpdateLogToFailure(final SysQueueLog sysQueueLog, final Exception ex) {
		if (sysQueueLog == null) {
			return;
		}

		try {
			sysQueueLog.initAudit(null);
			sysQueueLog.setStatus(SysQueueLogStatus.F);
			sysQueueLog.setStatusMessage(_Exp.getMessage(ex));
			sysQueueLog.setFinishTime(_Sys.now());
			sysQueueLogDao.getJpa().save(sysQueueLog);

		} catch(Exception e) {
			log.error(getClass().getName(), e);
		}
	}

}
