package com.github027.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.google.common.io.Closer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class _Exp {

	/**
	 * print stack trace to string
	 * 
	 * @param e
	 * @return
	 */
	public static String printStacktraceToString(final Exception e) {
		if (e == null) {
			return "";
		}

		final Closer closer = Closer.create();
		try {
			final Writer writer = closer.register(new StringWriter());
			final PrintWriter printWriter = closer.register(new PrintWriter(writer));
			e.printStackTrace(printWriter);
			return writer.toString();
		} finally {
			_Close.close(closer);
		}
	}

	/**
	 * get message
	 * 
	 * @param e
	 * @return
	 */
	public static String getMessage(final Exception e) {
		return (e == null) ? "" : e.getMessage();
	}

}
