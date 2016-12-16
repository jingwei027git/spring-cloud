package com.github027.app.queue.smoking;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github027.domain.enums.SysQueueLogCategory;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class SmokingListener {

	@Bean
	Queue queue() {
        return new Queue(SysQueueLogCategory.SMOKING.getQueueName(), false);
    }

	@RabbitListener(queues = "smokingQueue")
	public void receive(String message) {
		log.info("SmokingQueue test SUCCESS with message : {}", message);
    }

}

