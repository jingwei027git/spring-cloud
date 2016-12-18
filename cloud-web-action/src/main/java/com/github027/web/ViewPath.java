package com.github027.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ViewPath {

	mainLayout("app/layout/mainLayout"),
	onlineLayout("app/layout/onlineLayout"),

	dashboard("app/dashboard"),
	profile("app/profile")
	;

	@Getter
	private String path;

	public String with(String appendPath) {
		return getPath() + appendPath;
	}

}
