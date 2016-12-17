package com.github027.domain.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AmqpConst {

	@Getter
	@AllArgsConstructor
	public enum Category {
		SMOKING(SMOKING_EXCHANGE, SMOKING_ROUTING_KEY),
		EMAIL(EMAIL_EXCHANGE, EMAIL_ROUTING_KEY)
		;

		private String exchange;
		private String routingKey;
	}

	private static final String SMOKING_EXCHANGE = "smokingExchange";
	private static final String SMOKING_ROUTING_KEY = "";
	public static final String SMOKING_QUEUE_PROCESS = "smokingQueueProcess";

	private static final String EMAIL_EXCHANGE = "emailExchange";
	private static final String EMAIL_ROUTING_KEY = "";
	public static final String EMAIL_QUEUE_PROCESS = "emailQueueProcess";
	public static final String EMAIL_QUEUE_BACKUP = "emailQueueBackup";

}
