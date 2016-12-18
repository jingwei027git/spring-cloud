package com.github027.core.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseAction {

	@Autowired
	private HttpServletRequest request;

}
