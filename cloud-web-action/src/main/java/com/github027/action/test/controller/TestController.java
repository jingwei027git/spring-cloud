package com.github027.action.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.github027.config.Config;

@Controller
public class TestController {

	@Autowired
	private Config config;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String goHello(Model model) {
		model.addAttribute("name", "Spring Boot");
		model.addAttribute("profileName", config.getCloudConfigProfile());

		return "hello";
	}

	@RequestMapping("/loadBalance")
	public String goLoadBalance(Model model) {
		Integer serverPort = restTemplate.getForEntity("http://DOMAIN-SERVICE/test/serverPort", Integer.class)
				.getBody();
		model.addAttribute("serverPort", serverPort);

		return "hello";
	}

}
