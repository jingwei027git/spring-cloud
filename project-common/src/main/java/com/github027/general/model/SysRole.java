package com.github027.general.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github027.core.enums.YesNo;
import com.github027.core.model.ModelIdAudit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "users" })
@Entity
@Table(name = "sys_role")
@SuppressWarnings("serial")
public class SysRole extends ModelIdAudit {

	@Enumerated(EnumType.STRING)
	private YesNo sysStatus;

	private String code;

	private String name;

	private String description;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private List<SysUser> users;

}
