package com.github027.domain.dao;

import com.github027.core.dao.ModelDao;
import com.github027.domain.jpa.SysQueueLogJpa;
import com.github027.domain.model.SysQueueLog;

public interface SysQueueLogDao extends ModelDao<SysQueueLog, Long> {

	@Override
	public SysQueueLogJpa getJpa();

}
