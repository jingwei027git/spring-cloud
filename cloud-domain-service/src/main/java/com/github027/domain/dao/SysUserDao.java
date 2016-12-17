package com.github027.domain.dao;

import com.github027.core.dao.ModelDao;
import com.github027.domain.jpa.SysUserJpa;
import com.github027.domain.model.SysUser;

public interface SysUserDao extends ModelDao<SysUser, Long> {

	@Override
	public SysUserJpa getJpa();

}
