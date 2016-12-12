package com.github027.core.mapper.deserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github027.util._Str;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalendarJsonDeserializer extends JsonDeserializer<Calendar> {

	@Override
	public Calendar deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
		Calendar calendar = null;
		try {
			if (_Str.isBlank(jp.getText())) {
				if (_Str.isNumber(jp.getText())) {
					final Calendar c = Calendar.getInstance();
					c.setTimeInMillis(Long.parseLong(jp.getText()));
					calendar = c;
				} else if (jp.getText().indexOf('T') != -1) {
					final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
					final Calendar c = Calendar.getInstance();
					c.setTimeInMillis(sdf.parse(jp.getText()).getTime());
					calendar = c;
				} else {
					final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					final Calendar c = Calendar.getInstance();
					c.setTimeInMillis(sdf.parse(jp.getText()).getTime());
					calendar = c;
				}
			}
		} catch (final Exception e) {
			log.error("deserializer", e);
		}
		return calendar;
	}

}
