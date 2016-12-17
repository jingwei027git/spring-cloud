package com.github027.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github027.domain.dao.SysUserDao;
import com.github027.domain.model.SysUser;
import com.github027.domain.service.SysUserService;
import com.github027.util._Iter;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		List<SysUser> users = sysUserDao.getJpa().findByUsername(loginName);

		return _Iter.getFirst(users);
	}

}
