package com.github027.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@Value("${lucky-name}")
	private String luckyName;

	@RequestMapping("/lucky-name")
	public String showLuckyWord() {
		return "The lucky name is: " + luckyName;
	}

}
