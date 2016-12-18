package com.github027.domain.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github027.domain.model.SysUser;
import com.github027.util._Iter;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {

	@Autowired
	private SecurityUserJpa sysUserJpa;

	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		List<SysUser> users = sysUserJpa.findByUsername(loginName);

		return _Iter.getFirst(users);
	}

}
