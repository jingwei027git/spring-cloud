package com.github027.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github027.core.dao.ModelDaoImpl;
import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.jpa.SysQueueLogJpa;
import com.github027.domain.model.SysQueueLog;

import lombok.Getter;

@Repository("SysQueueLogDao")
public class SysQueueLogDaoImpl extends ModelDaoImpl<SysQueueLog, Long> implements SysQueueLogDao {

	@Getter
	@Autowired
	private SysQueueLogJpa jpaRepository;

}
