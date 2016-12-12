package com.github027.domain.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github027.domain.dao.SysUserDao;
import com.github027.domain.jpa.SysUserJpa;
import com.github027.domain.model.SysUser;
import com.github027.domain.service.SysUserService;
import com.github027.util._Iter;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Resource(name = "SysUserDao")
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysUserJpa sysUserJpa;

	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		List<SysUser> users = sysUserJpa.findByUsername(loginName);
		
		return _Iter.getFirst(users);
	}

}
