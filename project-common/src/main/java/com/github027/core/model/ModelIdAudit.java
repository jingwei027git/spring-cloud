package com.github027.core.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * Model with unique id and audit fields
 * 
 */
@Getter
@Setter
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class ModelIdAudit extends ModelId {

	private String createUser;

	private LocalDateTime createTime;

	private String modifyUser;

	private LocalDateTime modifyTime;

	/**
	 * initial audit fields
	 * <p>
	 * 1. Renew modify user and modify time. <br>
	 * 2. Renew create user and create time when id is null. <br>
	 * <p>
	 * 
	 * @param user
	 */
	public void initAudit(final String user) {
		final LocalDateTime dateTime = LocalDateTime.now();

		setModifyUser(user);
		setModifyTime(dateTime);

		if (getId() == null) {
			setCreateUser(user);
			setCreateTime(dateTime);
		}
	}

}
