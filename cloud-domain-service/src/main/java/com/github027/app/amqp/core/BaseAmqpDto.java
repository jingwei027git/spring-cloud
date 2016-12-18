package com.github027.app.amqp.core;

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
	private String username;
	private LocalDateTime sendTime;
	private LocalDateTime recvTime;
	private LocalDateTime finishTime;

}
