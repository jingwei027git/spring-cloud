package com.github027;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

@RemoteApplicationEventScan
@SpringBootApplication
public class BusConfig {

	public static void main(String[] args) {
		SpringApplication.run(BusConfig.class, args);
	}
}
