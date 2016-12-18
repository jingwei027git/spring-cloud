package com.github027.app.amqp.core;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@SuppressWarnings("serial")
public class BaseAmqpDto implements Serializable {

	@Getter
	@Setter
	private Long sysQueueLogId;

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private LocalDateTime sendTime;

	@Getter
	@Setter
	private LocalDateTime recvTime;

	@Getter
	@Setter
	private LocalDateTime finishTime;

}
