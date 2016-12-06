package com.github027;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ServiceReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceReservationApplication.class, args);
	}
}
