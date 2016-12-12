package com.github027.util;

import java.util.function.Consumer;

import com.google.common.io.Closer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class _Close {

	/**
	 * safe close resource
	 * 
	 * @param closer
	 */
	public static void close(final Closer closer) {
		close(closer, (e) -> {
			// ignore exception
		});
	}

	/**
	 * safe close resource
	 * 
	 * @param closer
	 * @param exceptionConsumer
	 */
	public static void close(final Closer closer, final Consumer<Exception> exceptionConsumer) {
		try {
			if (closer != null) {
				closer.close();
			}
		} catch (Exception e) {
			exceptionConsumer.accept(e);
		}
	}

}
