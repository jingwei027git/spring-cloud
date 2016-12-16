package com.github027.core.model;

import static com.github027.util._Str.isBlank;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Model with unique id and audit fields
 *
 */
@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
public abstract class ModelIdAudit extends ModelId {
	private static final long serialVersionUID = 1L;

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
	public void initAudit(final String username) {
		final LocalDateTime dateTime = LocalDateTime.now();

		if (!isBlank(username)) {
			setModifyUser(username);
		}
		setModifyTime(dateTime);

		if (getId() == null) {
			if (!isBlank(username)) {
				setCreateUser(username);
			}
			setCreateTime(dateTime);
		}
	}

}
