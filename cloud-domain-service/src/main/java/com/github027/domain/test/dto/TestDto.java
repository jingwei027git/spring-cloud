package com.github027.domain.test.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class TestDto implements Serializable {

	private Integer serverPort;
	private String code;
	private String description;

	private LocalDateTime createDate;
	private String createUser;
	private LocalDateTime modifyDate;
	private String modifyUser;
}
