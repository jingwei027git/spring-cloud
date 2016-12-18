package com.github027.domain.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github027.domain.model.SysUser;

@Repository
public interface SecurityUserJpa extends JpaRepository<SysUser, Long> {

	public List<SysUser> findByUsername(final String username);

}
