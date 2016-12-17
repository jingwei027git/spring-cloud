package com.github027.core.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import com.github027.util._Sys;

import lombok.Getter;
import lombok.Setter;

/**
 * Model with unique id and audit fields (only create)
 *
 */
@Getter
@Setter
@MappedSuperclass
public abstract class ModelIdAuditCreate extends ModelId {
	private static final long serialVersionUID = 1L;

	private String createUser;

	private LocalDateTime createTime;

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
		final LocalDateTime dateTime = _Sys.now();

		if (getId() == null) {
			setCreateUser(user);
			setCreateTime(dateTime);
		}
	}

}
