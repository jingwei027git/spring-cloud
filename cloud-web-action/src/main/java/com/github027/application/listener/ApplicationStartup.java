package com.github027.application.listener;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.github027.app.queue.core.service.QueueProducer;
import com.github027.domain.enums.SysQueueLogCategory;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private QueueProducer queueProducer;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		smokingQueueTest();
	}

	private void smokingQueueTest() {
		queueProducer.sendNative(SysQueueLogCategory.SMOKING.getQueueName(), LocalDateTime.now().toString());
	}

}
