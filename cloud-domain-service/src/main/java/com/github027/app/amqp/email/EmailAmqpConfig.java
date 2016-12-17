package com.github027.app.amqp.email;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github027.domain.consts.AmqpConst;

@Component
public class EmailAmqpConfig {

	@Bean
	Queue processQueue() {
        return new Queue(AmqpConst.EMAIL_QUEUE_PROCESS, true);
    }

	@Bean
	Queue backupQueue() {
        return new Queue(AmqpConst.EMAIL_QUEUE_BACKUP, true);
    }

	@Bean
	FanoutExchange exchange() {
		return new FanoutExchange(AmqpConst.Category.EMAIL.getExchange(), true, false);
	}

	@Bean
	List<Binding> binding(Exchange exchange) {
		final Binding bindProcessQueue = BindingBuilder.bind(processQueue()).to(exchange());
		final Binding bindBackupQueue = BindingBuilder.bind(backupQueue()).to(exchange());

		return Arrays.asList(bindProcessQueue, bindBackupQueue);
	}

}
