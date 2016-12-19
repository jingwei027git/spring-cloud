package com.github027.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.github027.core.model.ModelIdAudit;
import com.github027.domain.model.consts.AmqpConst;
import com.github027.domain.model.enums.SysQueueLogStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * System RabbitMq send and receive log
 *
 */
@SuppressWarnings("serial")
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sys_queue_log")
public class SysQueueLog extends ModelIdAudit {

	@NotNull
	private Long siteId;

	private Long userId;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AmqpConst.Category category;

	@NotNull
	private LocalDateTime sendTime;		// this time is before send to queue

	private LocalDateTime recvTime;		// this time is receive from queue

	private LocalDateTime finishTime;	// this time is receive and process done (success or failure)

	@NotNull
	@Enumerated(EnumType.STRING)
	private SysQueueLogStatus status;

	private String statusMessage;

}
