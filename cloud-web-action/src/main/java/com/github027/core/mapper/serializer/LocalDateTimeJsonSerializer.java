package com.github027.core.mapper.serializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime> {

	@Override
	public void serialize(final LocalDateTime value, final JsonGenerator jgen, final SerializerProvider provider) throws IOException {
		try {
			final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
			jgen.writeString(value.format(formatter));
		} catch (final Exception e) {
			log.error("serializer", e);
			jgen.writeString("");
		}
	}

}
