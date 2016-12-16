package com.github027.app.queue.core;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.enums.SysQueueLogStatus;
import com.github027.domain.model.SysQueueLog;
import com.github027.util._Exp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseQueueReceiver<T extends BaseQueueDto> {

	@Resource(name = "SysQueueLogDao")
	private SysQueueLogDao sysQueueLogDao;


	public abstract void receive(final T t);

	public void handleMessage(final T t) {
		SysQueueLog sysQueueLog = null;
		try {
			sysQueueLog = updateLogToReceived(t);
			receive(t);
			updateLogToSuccess(sysQueueLog);

		} catch (Exception e) {
			log.error(getClass().getName(), e);
			updateLogToFailure(sysQueueLog, e);
			/*
			 * =============================================================
			 * Queue must consumed no matter have exception or not. If throw
			 * exception here will cause infinite loop.
			 * =============================================================
			 */
		}
	}

	private SysQueueLog updateLogToReceived(final T t) {
		final SysQueueLog sysQueueLog = sysQueueLogDao.getJpaRepository().findOne(t.getSysQueueLogId());
		sysQueueLog.initAudit(null);
		sysQueueLog.setStatus(SysQueueLogStatus.R);
		sysQueueLog.setRecvTime(LocalDateTime.now());

		return sysQueueLogDao.save(sysQueueLog);
	}

	private void updateLogToSuccess(final SysQueueLog sysQueueLog) {
		sysQueueLog.initAudit(null);
		sysQueueLog.setStatus(SysQueueLogStatus.S);
		sysQueueLog.setFinishTime(LocalDateTime.now());
		sysQueueLogDao.save(sysQueueLog);
	}

	private void updateLogToFailure(final SysQueueLog sysQueueLog, final Exception ex) {
		if (sysQueueLog == null) {
			return;
		}

		try {
			sysQueueLog.initAudit(null);
			sysQueueLog.setStatus(SysQueueLogStatus.F);
			sysQueueLog.setFinishTime(LocalDateTime.now());
			sysQueueLog.setComment(_Exp.getMessage(ex));
			sysQueueLogDao.save(sysQueueLog);
		} catch(Exception e) {
			log.error(getClass().getName(), e);
		}
	}

}
