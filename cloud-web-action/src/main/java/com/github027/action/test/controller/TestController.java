package com.github027.action.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.github027.config.Config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	
	@Autowired
	protected HttpServletRequest request;

	@Autowired
	private Config config;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SessionRepository<?> sessRepo;

	@RequestMapping("/hello")
	public String goHello(Model model) {
		model.addAttribute("name", "Spring Boot");
		model.addAttribute("profileName", config.getCloudConfigProfile());
		model.addAttribute("sessionID", request.getSession().getId());
		
		log.info("HttpSession ID is {}", request.getSession().getId());

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
