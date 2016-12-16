package com.github027.app.test.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.github027.app.queue.core.service.QueueProducer;
import com.github027.app.queue.email.EmailReceiverDto;
import com.github027.domain.enums.SysQueueLogCategory;
import com.github027.domain.enums.UserType;

@RequestMapping("/test")
@Controller
public class TestRestController {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private QueueProducer queueProducer;

	@RequestMapping("/sendToQueue")
	public ResponseEntity<Void> goLoadBalance(Model model) {
		EmailReceiverDto emailDto = new EmailReceiverDto("system");
		emailDto.setFromAlias("testAlias");
		emailDto.setFromEmail("test@softpower.com.tw");
		emailDto.setUsername(UserType.SYSTEM.toString());

		queueProducer.send(SysQueueLogCategory.EMAIL, emailDto);

		return ResponseEntity.ok().build();
	}

	@RequestMapping("/queueSize/{queueName}")
	public ResponseEntity<Void> getQueueSize(@PathVariable String queueName, Model model) {
//		restTemplate.ex
		return null;
	}

}
