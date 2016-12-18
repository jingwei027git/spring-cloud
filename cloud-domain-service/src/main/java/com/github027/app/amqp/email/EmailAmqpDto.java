package com.github027.app.amqp.email;

import java.io.File;
import java.util.List;

import com.github027.core.amqp.BaseAmqpDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString(callSuper = true, exclude = { "context", "attachments" })
public class EmailAmqpDto extends BaseAmqpDto {

	private String fromAlias;
	private String fromEmail;
	private List<String> toEmails;
	private List<String> ccEmails;
	private List<String> bccEmails;
	private String subject;
	private String context;
	private List<File> attachments;

}
