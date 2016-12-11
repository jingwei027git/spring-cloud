package com.github027.app.test.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.github027.application.property.Config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestAction {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	private Config config;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String goHello(Model model) {
		model.addAttribute("name", "Spring Boot");
		model.addAttribute("profileName", config.getCloudConfigProfile());
		model.addAttribute("sessionID", request.getSession().getId());

		log.info("HttpSession ID is {}", request.getSession().getId());
		log.info("Key redis is {}", request.getSession().getAttribute("redis"));

		return "hello";
	}

	@RequestMapping("/loadBalance")
	public String goLoadBalance(Model model) {
		Integer serverPort = restTemplate.getForEntity("http://DOMAIN-SERVICE/test/serverPort", Integer.class).getBody();
		model.addAttribute("serverPort", serverPort);

		return "hello";
	}

}
