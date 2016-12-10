package com.github027.general.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github027.general.dao.SysUserDao;
import com.github027.general.model.SysUser;
import com.github027.general.service.SysUserService;
import com.github027.general.util._Iter;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Resource(name = "SysUserDao")
	private SysUserDao sysUserDao;

	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		List<SysUser> users = sysUserDao.getJpaRepository().findByUsername(loginName);
		
		return _Iter.getFirst(users);
	}

}
