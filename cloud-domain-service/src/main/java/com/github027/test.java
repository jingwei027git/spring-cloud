package com.github027;

import java.time.LocalDateTime;

import com.github027.domain.model.SysUser;

public class test {

	public static void main(String[] args) {
		SysUser sysUser = new SysUser();
		sysUser.setId(100L);
		sysUser.setCreateUser("jeff");
		sysUser.setCreateTime(LocalDateTime.now());

		System.out.println(sysUser);
	}

}
