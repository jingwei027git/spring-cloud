package com.github027.app.amqp.smoking;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github027.domain.model.consts.AmqpConst;

@Component
public class SmokingAmqpConfig {

	@Bean
	Queue processQueue() {
        return new Queue(AmqpConst.SMOKING_QUEUE_PROCESS, true);
    }

	@Bean
	FanoutExchange exchange() {
		return new FanoutExchange(AmqpConst.Category.SMOKING.getExchange(), true, false);
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(processQueue()).to(exchange());
	}

}
