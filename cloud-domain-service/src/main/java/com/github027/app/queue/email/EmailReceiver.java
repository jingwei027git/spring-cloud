package com.github027.app.queue.email;

import org.springframework.stereotype.Component;

import com.github027.app.queue.core.BaseQueueReceiver;

@Component
public class EmailReceiver extends BaseQueueReceiver<EmailReceiverDto> {

	@Override
	public void receive(final EmailReceiverDto email) {
        System.out.println("Received <" + email + ">");
    }

}
