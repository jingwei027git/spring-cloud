package com.github027.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.github027.core.model.ModelIdAudit;
import com.github027.domain.enums.SysQueueLogCategory;
import com.github027.domain.enums.SysQueueLogStatus;

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

	private String uuid;

	@Enumerated(EnumType.STRING)
	private SysQueueLogStatus status;

	@Enumerated(EnumType.STRING)
	private SysQueueLogCategory category;

	private LocalDateTime sendTime;		// this time is baseQueueDto is ready and prepare to send

	private LocalDateTime recvTime;		// this time is baseQueueReceiver receive and prepare to process

	private LocalDateTime finishTime;	// this time is baseQueueReceiver receive and process done (include failure case)

	private String comment;

}
