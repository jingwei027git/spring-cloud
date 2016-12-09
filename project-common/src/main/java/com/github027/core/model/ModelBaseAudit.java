package com.github027.core.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * include {create_user, create_time, modify_user, modify_time}
 * <p>
 * <p>
 */
@Getter
@Setter
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class ModelBaseAudit extends ModelBase {
	
    private String createUser;
    
    private LocalDateTime createTime;
    
    private String modifyUser;
    
    private LocalDateTime modifyTime;

    public void initAuditBase(
        final String user)
    {
        final LocalDateTime dateTime = LocalDateTime.now();

        setModifyUser(user);
        setModifyTime(dateTime);

        if (getId() == null) {
            setCreateUser(user);
            setCreateTime(dateTime);
        }
    }
}
