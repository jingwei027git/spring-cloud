package com.github027.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github027.core.dao.ModelDaoImpl;
import com.github027.domain.dao.SysUserDao;
import com.github027.domain.jpa.SysUserJpa;
import com.github027.domain.model.SysUser;

import lombok.Getter;

@Repository
public class SysUserDaoImpl extends ModelDaoImpl<SysUser, Long> implements SysUserDao {

	@Getter
	@Autowired
	private SysUserJpa jpa;

}
