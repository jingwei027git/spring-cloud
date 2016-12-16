package com.github027.app.queue.core;

import static com.github027.util._Str.trim;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@SuppressWarnings("serial")
public class BaseQueueDto implements Serializable {

	@Getter
	@Setter
	private Long sysQueueLogId;

	@Getter
	private String uuid;

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

	public BaseQueueDto(String username) {
		this.uuid = UUID.randomUUID().toString();
		this.username = trim(username);
	}

}
