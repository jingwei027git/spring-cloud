package com.github027.app.queue.core.service.impl;

import static com.github027.util._Str.trimToNull;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github027.app.queue.core.BaseQueueDto;
import com.github027.app.queue.core.service.QueueProducer;
import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.enums.SysQueueLogCategory;
import com.github027.domain.enums.SysQueueLogStatus;
import com.github027.domain.model.SysQueueLog;
import com.google.common.base.Preconditions;

@Service("QueueProducer")
public class QueueProducerImpl implements QueueProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Resource(name = "SysQueueLogDao")
	private SysQueueLogDao sysQueueLogDao;

	@Override
	public void send(final SysQueueLogCategory category, final BaseQueueDto dto) {
		Preconditions.checkNotNull(category);

		saveLog(category, dto);
		produce(category, dto);
	}

	@Override
	public void sendNative(String queueName, Object object) {
		Preconditions.checkNotNull(trimToNull(queueName));

		rabbitTemplate.convertAndSend(queueName, object);
	}

	private void saveLog(final SysQueueLogCategory category, final BaseQueueDto dto) {
		SysQueueLog model = new SysQueueLog();
		BeanUtils.copyProperties(dto, model);
		model.initAudit(dto.getUsername());
		model.setCategory(category);
		model.setStatus(SysQueueLogStatus.I);
		model.setSendTime(LocalDateTime.now());

		sysQueueLogDao.save(model);
		dto.setSysQueueLogId(model.getId());
	}

	private void produce(final SysQueueLogCategory category, final BaseQueueDto dto) {
		rabbitTemplate.convertAndSend(category.getQueueName(), dto);
	}

}
