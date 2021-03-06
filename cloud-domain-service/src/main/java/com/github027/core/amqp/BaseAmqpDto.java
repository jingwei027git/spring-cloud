package com.github027.core.amqp;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class BaseAmqpDto implements Serializable {

	private Long sysQueueLogId;
	private Long siteId;
	private Long userId;				// specify to SysUser.id

	private String username;			// for ModelIdAudit.createUser & ModelIdAudit.modifyUser
	private LocalDateTime sendTime;
	private LocalDateTime recvTime;
	private LocalDateTime finishTime;

}
