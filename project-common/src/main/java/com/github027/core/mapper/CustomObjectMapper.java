package com.github027.core.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class CustomObjectMapper extends ObjectMapper {

	public CustomObjectMapper() {
		super();
		registerModules(CustomObjectMapper.getRisterModules());
	}

	public static List<Module> getRisterModules() {
		final List<Module> modules = new ArrayList<>();

		modules.add(new JsonSimpleModule());

		return modules;
	}

}
