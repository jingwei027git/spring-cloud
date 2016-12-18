package com.github027.app.amqp.smoking;

import com.github027.app.amqp.core.BaseAmqpDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString(callSuper = true, exclude = {})
public class SmokingAmqpDto extends BaseAmqpDto {

	private String message;

}
