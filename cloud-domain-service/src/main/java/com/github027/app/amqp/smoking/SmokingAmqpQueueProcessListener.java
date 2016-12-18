package com.github027.app.amqp.smoking;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.github027.core.amqp.BaseAmqpLogableListener;
import com.github027.domain.model.consts.AmqpConst;

@Component
public class SmokingAmqpQueueProcessListener extends BaseAmqpLogableListener<SmokingAmqpDto> {

	@RabbitListener(queues = AmqpConst.SMOKING_QUEUE_PROCESS)
	@Override
	protected void receive(final SmokingAmqpDto dto) {
		handleMessage(dto, t -> {
			System.out.println(t);
		});
	}

}