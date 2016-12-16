package com.github027.app.queue.core;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;

import com.github027.domain.enums.SysQueueLogCategory;

public abstract class BaseQueueListener {

	protected abstract SysQueueLogCategory provideCategory();

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		System.out.println(connectionFactory.getVirtualHost());
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(provideCategory().getQueueName());
		container.setMessageListener(listenerAdapter);
		return container;
	}

}
