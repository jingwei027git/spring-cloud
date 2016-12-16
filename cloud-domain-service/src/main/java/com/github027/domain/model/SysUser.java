package com.github027.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github027.core.enums.YesNo;
import com.github027.core.model.ModelIdAudit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * System user model with Spring Security
 *
 */
@Getter
@Setter
@ToString(callSuper = true, exclude = { "description", "password" })
@Entity
@Table(name = "sys_user")
public class SysUser extends ModelIdAudit implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private YesNo sysStatus;

	private String username; // alias name or login name or ...

	private String firstname;

	private String lastname;

	private String email;

	private String description;

	@JsonIgnore
	private String password;

	private LocalDateTime expireTime;

//	@JsonIgnore
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
//			@JoinColumn(name = "role_id", referencedColumnName = "id") })
//	private List<SysRole> roles;

	public SysUser() {
		sysStatus = YesNo.Y;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return grantedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return expireTime == null || expireTime.isAfter(LocalDateTime.now());
	}

	@Override
	public boolean isAccountNonLocked() {
		return YesNo.Y == getSysStatus();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return YesNo.Y == getSysStatus();
	}

}
