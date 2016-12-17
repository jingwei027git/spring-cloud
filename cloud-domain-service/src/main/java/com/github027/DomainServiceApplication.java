package com.github027;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@EntityScan(basePackages = { "com.github027.domain.model" }, basePackageClasses = { Jsr310JpaConverters.class })
@EnableDiscoveryClient
@SpringBootApplication
public class DomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainServiceApplication.class, args);
	}

}
