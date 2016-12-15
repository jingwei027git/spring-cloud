package com.github027.app.queue.email;

import java.io.File;
import java.util.List;

import com.github027.app.queue.core.BaseQueueDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString(exclude = { "context", "attachments" }, callSuper = true)
public class EmailReceiverDto extends BaseQueueDto {

	private String fromAlias;
	private String fromEmail;
	private List<String> toEmails;
	private List<String> ccEmails;
	private List<String> bccEmails;
	private String subject;
	private String context;
	private List<File> attachments;

	public EmailReceiverDto(String createUser) {
		super(createUser);
	}

}
