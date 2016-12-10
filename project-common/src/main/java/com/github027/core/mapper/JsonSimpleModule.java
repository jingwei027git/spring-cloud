package com.github027.core.mapper;

import java.time.LocalDateTime;
import java.util.Calendar;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github027.core.mapper.deserializer.CalendarJsonDeserializer;
import com.github027.core.mapper.deserializer.LocalDateTimeJsonDeserializer;
import com.github027.core.mapper.serializer.CalendarJsonSerializer;
import com.github027.core.mapper.serializer.LocalDateTimeJsonSerializer;

@SuppressWarnings("serial")
public class JsonSimpleModule extends SimpleModule {

	public JsonSimpleModule() {
		addDeserializer(Calendar.class, new CalendarJsonDeserializer());
		addSerializer(Calendar.class, new CalendarJsonSerializer());

		addDeserializer(LocalDateTime.class, new LocalDateTimeJsonDeserializer());
		addSerializer(LocalDateTime.class, new LocalDateTimeJsonSerializer());
	}

}
