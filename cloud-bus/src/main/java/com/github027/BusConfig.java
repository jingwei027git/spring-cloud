package com.github027;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RemoteApplicationEventScan
@SpringBootApplication
public class BusConfig {

	public static void main(String[] args) {
		SpringApplication.run(BusConfig.class, args);
	}
}
