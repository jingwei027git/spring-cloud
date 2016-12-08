package com.github027;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class DomainServiceApplication {
	
	@Value("${spring.rabbitmq.host}")
	private String rabbitMqHost;
	
	@Value("${spring.rabbitmq.port}")
	private Integer rabbitMqPort;
	
	@Value("${spring.rabbitmq.username}")
	private String rabbitMqUsername;
	
	@Value("${spring.rabbitmq.password}")
	private String rabbitMqPassword;
	
	@Bean
	public ConnectionFactory connectionFactory() {
		final CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(rabbitMqHost + ":" + rabbitMqPort);
		connectionFactory.setUsername(rabbitMqUsername);
		connectionFactory.setPassword(rabbitMqPassword);
		connectionFactory.setVirtualHost("/");
		connectionFactory.setPublisherConfirms(true);
		return connectionFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(DomainServiceApplication.class, args);
	}
}
