package com.github027.application.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github027.core.mapper.CustomObjectMapper;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("app/login/login");
		registry.addViewController("/login").setViewName("app/login/login");
		registry.addViewController("/hello").setViewName("hello");
	}

	@Override
	public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
		final MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
		jacksonConverter.setObjectMapper(new CustomObjectMapper());
		jacksonConverter.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

		converters.add(jacksonConverter);
	}

}
