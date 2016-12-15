package com.github027.domain.enums;

import lombok.Getter;

public enum SysQueueLogCategory {

	EMAIL("emailQueue");

	@Getter
	private String queueName;

	SysQueueLogCategory(String queueName) {
		this.queueName = queueName;
	}

}
