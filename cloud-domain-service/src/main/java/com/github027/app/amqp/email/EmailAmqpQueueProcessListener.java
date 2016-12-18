package com.github027.app.amqp.email;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.github027.core.amqp.BaseAmqpLogableListener;
import com.github027.domain.model.consts.AmqpConst;

@Component
public class EmailAmqpQueueProcessListener extends BaseAmqpLogableListener<EmailAmqpDto> {

	@RabbitListener(queues = AmqpConst.EMAIL_QUEUE_PROCESS)
	@Override
	protected void receive(final EmailAmqpDto dto) {
		handleMessage(dto, t -> {
			System.out.println(t);
		});
	}

}
