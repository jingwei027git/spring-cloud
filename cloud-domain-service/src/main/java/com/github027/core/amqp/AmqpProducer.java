package com.github027.core.amqp;

import com.github027.domain.model.consts.AmqpConst;

public interface AmqpProducer {

	public void send(AmqpConst.Category category, BaseAmqpDto dto);

}
