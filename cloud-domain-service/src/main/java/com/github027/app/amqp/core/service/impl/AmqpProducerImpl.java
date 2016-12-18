package com.github027.app.amqp.core.service.impl;

import static com.github027.util._Str.trimToNull;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github027.app.amqp.core.BaseAmqpDto;
import com.github027.app.amqp.core.service.AmqpProducer;
import com.github027.domain.consts.AmqpConst;
import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.enums.SysQueueLogStatus;
import com.github027.domain.model.SysQueueLog;
import com.github027.util._Sys;
import com.google.common.base.Preconditions;

@Component
public class AmqpProducerImpl implements AmqpProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private SysQueueLogDao sysQueueLogDao;


	@Override
	public void send(final AmqpConst.Category category, final BaseAmqpDto dto) {
		Preconditions.checkNotNull(category);
		Preconditions.checkNotNull(dto);
		Preconditions.checkNotNull(trimToNull(dto.getUsername()));

		saveLogWithInitialStatus(category, dto);
		send(category.getExchange(), category.getRoutingKey(), dto);
	}

	private void saveLogWithInitialStatus(final AmqpConst.Category category, final BaseAmqpDto dto) {
		SysQueueLog model = new SysQueueLog();
		BeanUtils.copyProperties(dto, model);
		model.initAudit(dto.getUsername());
		model.setCategory(category);
		model.setStatus(SysQueueLogStatus.I);
		model.setSendTime(_Sys.now());

		sysQueueLogDao.getJpa().save(model);

		dto.setSysQueueLogId(model.getId());
	}

	private void send(final String exchange, final String routingKey, final Object object) {
		rabbitTemplate.convertAndSend(exchange, routingKey, object);
	}

}
