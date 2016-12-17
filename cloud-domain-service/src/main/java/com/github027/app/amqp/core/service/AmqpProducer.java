package com.github027.app.amqp.core.service;

import com.github027.app.amqp.core.BaseAmqpDto;
import com.github027.domain.consts.AmqpConst;

public interface AmqpProducer {

	public void send(AmqpConst.Category category, BaseAmqpDto dto);

}
