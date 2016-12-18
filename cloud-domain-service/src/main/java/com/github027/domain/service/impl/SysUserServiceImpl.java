package com.github027.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github027.core.service.ModelServiceImpl;
import com.github027.domain.dao.SysUserDao;
import com.github027.domain.model.SysUser;
import com.github027.domain.service.SysUserService;

import lombok.Getter;

@Service
public class SysUserServiceImpl extends ModelServiceImpl<SysUser, Long> implements SysUserService {

	@Getter
	@Autowired
	private SysUserDao dao;

}
