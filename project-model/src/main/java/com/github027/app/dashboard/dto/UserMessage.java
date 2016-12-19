package com.github027.app.dashboard.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class UserMessage implements Serializable {

	private String title;
	private String message;

}
