package com.github027.app.queue.core.service;

import com.github027.app.queue.core.BaseQueueDto;
import com.github027.domain.enums.SysQueueLogCategory;

public interface QueueProducer {

	public void send(SysQueueLogCategory category, BaseQueueDto dto);

	public void sendNative(String queueName, Object object);

}
