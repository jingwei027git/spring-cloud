package com.github027.domain.test;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github027.domain.test.dto.TestDto;

@RefreshScope
@RequestMapping("/test")
@RestController
public class TestRestController {
	
	@Value("${server.port}")
	private Integer serverPort;
	
	@Value("${lucky-name}")
	private String luckyName;

	@GetMapping("")
	public TestDto readSample() {
		TestDto testDto = new TestDto();
		testDto.setServerPort(serverPort);
		testDto.setCode(luckyName);
		testDto.setDescription("description");
		testDto.setCreateUser("system");
		testDto.setCreateDate(LocalDateTime.now());
		testDto.setModifyUser("system");
		testDto.setModifyDate(LocalDateTime.now());

		return testDto;
	}
	
	@GetMapping("serverPort")
	public Integer readServerPort() {
		return serverPort;
	}

}
