package com.github027.web;

import lombok.Getter;

public enum ViewPath {

	mainLayout("app/layout/mainLayout"),
	onlineLayout("app/layout/onlineLayout"),

	dashboard("app/dashboard"),
	profile("app/profile")
	;

	@Getter
	private String path;

	ViewPath(String path) {
		this.path = path;
	}

	public String with(String appendPath) {
		return getPath() + appendPath;
	}

}
