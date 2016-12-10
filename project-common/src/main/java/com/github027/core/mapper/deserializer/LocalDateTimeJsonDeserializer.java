package com.github027.core.mapper.deserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github027.general.util._Str;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
		LocalDateTime localDateTime = null;
		try {
			if (_Str.isBlank(jp.getText())) {
				if (_Str.isNumber(jp.getText())) {
					localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(jp.getText())), ZoneId.systemDefault());
				} else if (jp.getText().indexOf('T') != -1) {
					final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
					localDateTime = LocalDateTime.parse(jp.getText(), formatter);
				} else {
					final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					localDateTime = LocalDateTime.parse(jp.getText(), formatter);
				}
			}
		} catch (final Exception e) {
			log.error("deserializer", e);
		}
		return localDateTime;
	}

}
