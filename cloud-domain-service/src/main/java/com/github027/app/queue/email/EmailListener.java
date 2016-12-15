package com.github027.app.queue.email;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github027.app.queue.core.BaseQueueListener;
import com.github027.domain.enums.SysQueueLogCategory;

@Component
public class EmailListener extends BaseQueueListener {

	@Override
	protected SysQueueLogCategory provideCategory() {
		return SysQueueLogCategory.EMAIL;
	}

	@Bean
    MessageListenerAdapter listenerAdapter(EmailReceiver receiver) {
        return new MessageListenerAdapter(receiver);
    }

}
