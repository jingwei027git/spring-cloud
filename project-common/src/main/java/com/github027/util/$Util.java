package com.github027.util;

import com.google.common.collect.Iterables;
import com.google.common.io.Closer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class $Util {

	public static void close(Closer closer) {
		try {
			if (closer != null) {
				closer.close();
			}
		} catch (Exception e) {
			log.warn("close exception", e);
		}
	}

	public static StringBuffer concats(Object... strs) {
		if (strs == null || strs.length == 0) {
			return new StringBuffer("");

		} else {
			StringBuffer buf = new StringBuffer();
			for (final Object str : strs) {
				if (str != null) {
					buf.append(str.toString());
				}
			}
			return buf;
		}
	}

	public static <T> T getFirst(Iterable<T> iterable) {
		return (iterable == null) ? null : Iterables.getFirst(iterable, null);
	}

	public static <T> T getFirst(Iterable<T> iterable, T defaultValue) {
		return (iterable == null) ? null : Iterables.getFirst(iterable, defaultValue);
	}

	public static <T> T getLast(Iterable<T> iterable) {
		return (iterable == null) ? null : Iterables.getLast(iterable, null);
	}

	public static <T> T getLast(Iterable<T> iterable, T defaultValue) {
		return (iterable == null) ? null : Iterables.getLast(iterable, defaultValue);
	}
	
	public static boolean isBlank(String str) {
		return (str == null || str == "" || str.trim() == "");
	}
	
	public static boolean isEmpty(String str) {
		return (str == null || str == "");
	}

	public static boolean isNumber(String sNumber) {
		if (isEmpty((sNumber))) {
			return false;
		} else {
			try {
				Long.parseLong(sNumber);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

	public static int size(Iterable<?> iterable) {
		return iterable == null ? 0 : Iterables.size(iterable);
	}

	public static int length(String str) {
		return str == null ? 0 : str.length();
	}

}
