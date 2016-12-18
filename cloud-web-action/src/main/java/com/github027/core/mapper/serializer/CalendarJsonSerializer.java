package com.github027.core.mapper.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarJsonSerializer extends JsonSerializer<Calendar> {

	@Override
	public void serialize(Calendar value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			jgen.writeString(sdf.format(value.getTime()));
		} catch (Exception e) {
			log.error("serializer", e);
			jgen.writeString("");
		}
	}

}
