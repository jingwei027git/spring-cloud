package com.github027.app.test.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.github027.app.amqp.core.service.AmqpProducer;
import com.github027.app.amqp.email.EmailAmqpDto;
import com.github027.domain.consts.AmqpConst;
import com.github027.domain.enums.Character;

@RequestMapping("/test")
@Controller
public class TestRestController {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AmqpProducer queueProducer;

	@RequestMapping("/sendToQueue")
	public ResponseEntity<Void> goLoadBalance(Model model) {
		EmailAmqpDto emailDto = new EmailAmqpDto("system");
		emailDto.setFromAlias("testAlias");
		emailDto.setFromEmail("test@softpower.com.tw");
		emailDto.setUsername(Character.SYSTEM.toString());

		queueProducer.send(AmqpConst.Category.EMAIL, emailDto);

		return ResponseEntity.ok().build();
	}

	@RequestMapping("/queueSize/{queueName}")
	public ResponseEntity<Void> getQueueSize(@PathVariable String queueName, Model model) {
//		restTemplate.ex
		return null;
	}

}
