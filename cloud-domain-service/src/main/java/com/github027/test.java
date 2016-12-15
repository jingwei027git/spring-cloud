package com.github027;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.github027.app.queue.email.EmailReceiverDto;

public class test {

	public static void main(String[] args) {
		EmailReceiverDto dto = new EmailReceiverDto("system");

		System.out.println(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE)+ ":" + UUID.randomUUID().toString());
	}

}
