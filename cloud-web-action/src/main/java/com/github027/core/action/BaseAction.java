package com.github027.core.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public abstract class BaseAction {

	@Getter
	@Autowired
	private HttpServletRequest request;

}
