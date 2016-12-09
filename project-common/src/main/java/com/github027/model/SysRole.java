package com.github027.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@ToString(exclude = { "operations", "users" })
@Entity
@Table(name = "sys_role")
@SuppressWarnings("serial")
public class SysRole extends ModelBaseAudit {
    @Enumerated(EnumType.STRING)
    private YesNo sysStatus;

    private String code;

    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "sys_role_operation", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "operation_id", referencedColumnName = "id") })
    private List<SysOperation> operations;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<SysUser> users;

}
