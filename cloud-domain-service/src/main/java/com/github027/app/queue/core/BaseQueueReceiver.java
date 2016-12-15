package com.github027.app.queue.core;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.enums.SysQueueLogStatus;
import com.github027.domain.model.SysQueueLog;

public abstract class BaseQueueReceiver<T extends BaseQueueDto> {

	@Resource(name = "SysQueueLogDao")
	private SysQueueLogDao sysQueueLogDao;


	public abstract void receive(final T t);

	public void handleMessage(final T t) {
		saveLog(t);
		receive(t);
	}

	private void saveLog(final T t) {
		final SysQueueLog sysQueueLog = sysQueueLogDao.getJpaRepository().findOne(t.getSysQueueLogId());
		sysQueueLog.initAudit(null);
		sysQueueLog.setStatus(SysQueueLogStatus.R);
		sysQueueLog.setRecvTime(LocalDateTime.now());
		sysQueueLogDao.save(sysQueueLog);
	}

}
