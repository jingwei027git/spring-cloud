package com.github027.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github027.core.enums.YesNo;
import com.github027.core.model.ModelBaseAudit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "roles", "users" })
@Entity
@Table(name = "sys_operation")
@SuppressWarnings("serial")
public class SysOperation extends ModelBaseAudit {
    @Enumerated(EnumType.STRING)
    private YesNo sysStatus;

    private String code;

    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "operations")
    private List<SysRole> roles;

    @JsonIgnore
    @ManyToMany(mappedBy = "operations")
    private List<SysUser> users;
}
