package com.github027.app.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github027.app.dashboard.dto.UserMessage;

@RequestMapping("/dashboard")
@RestController
public class DashboardController {

	@GetMapping(params = "resource=userAlerts")
	public ResponseEntity<List<UserMessage>> listUserAlerts() {
		List<UserMessage> userMessages = new ArrayList<>();

		UserMessage userMessage = new UserMessage();
		userMessage.setTitle("this is title");
		userMessage.setMessage("dkljsdl dsfklsndf dds 中文");

		userMessages.add(userMessage);

		return ResponseEntity.ok(userMessages);
	}

}
