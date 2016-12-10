package com.github027.general.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github027.core.jpa.ModelJpa;
import com.github027.general.model.SysUser;

@Repository
public interface SysUserJpa extends ModelJpa<SysUser, Long> {
	
	public List<SysUser> findByUsername(final String username);

}
