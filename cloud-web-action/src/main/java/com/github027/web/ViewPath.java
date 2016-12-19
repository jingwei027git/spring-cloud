package com.github027.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ViewPath {

	adminLayout("app/layout/layout-admin"),
	onlineLayout("app/layout/layout-online"),

	dashboard("app/dashboard"),
	profile("app/profile")
	;

	@Getter
	private String path;

	public String with(String appendPath) {
		return getPath() + appendPath;
	}

}
