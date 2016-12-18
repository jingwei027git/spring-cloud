package com.github027.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.github027.core.enums.YesNo;
import com.github027.core.model.ModelIdAudit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, exclude = { "description" })
@Entity
@Table(name = "sys_role")
public class SysRole extends ModelIdAudit {
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private YesNo sysStatus;

	private String code;

	private String name;

	private String description;

//	@JsonIgnore
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
//			@JoinColumn(name = "user_id", referencedColumnName = "id") })
//	private List<SysUser> users;

}
