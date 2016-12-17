package com.github027.application.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Config {
	
	@Value("${spring.datasource.driverClassName}")
	private String datasourceDriverClassName;

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String datasourceUsername;

	@Value("${spring.datasource.password}")
	private String datasourcePassword;

	@Value("${spring.cloud.config.profile}")
	private String cloudConfigProfile;
	
	@Value("${spring.rabbitmq.host}")
	private String rabbitmqHost;
	
	@Value("${spring.rabbitmq.port}")
	private String rabbitmqPort;
	
	@Value("${spring.rabbitmq.username}")
	private String rabbitmqUsername;
	
	@Value("${spring.rabbitmq.password}")
	private String rabbitmqPassword;
	
}
