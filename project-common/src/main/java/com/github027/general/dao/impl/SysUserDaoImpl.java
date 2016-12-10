package com.github027.general.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github027.core.dao.ModelDaoImpl;
import com.github027.general.dao.SysUserDao;
import com.github027.general.jpa.SysUserJpa;
import com.github027.general.model.SysUser;

import lombok.Getter;

@Repository("SysUserDao")
public class SysUserDaoImpl extends ModelDaoImpl<SysUser, Long> implements SysUserDao {
	
	@Getter
	@Autowired
	private SysUserJpa jpaRepository;

}
