package com.github027.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class _Str {

	/**
	 * append all objects(.toString()) into string buffer (null object will be
	 * ignore)
	 * 
	 * @param strs
	 * @return
	 */
	public static StringBuffer concats(final Object... strs) {
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

	/**
	 * determine string is blank or not
	 * <p>
	 * 1. null is blank <br>
	 * 2. "" is blank <br>
	 * 3. " " is blank <br>
	 * 4. "   " is blank (any number white spaces) <br>
	 * <p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(final String str) {
		return (str == null || "".equals(str) || "".equals(str.trim()));
	}

	/**
	 * determine string is empty or not
	 * <p>
	 * 1. null is blank <br>
	 * 2. "" is blank <br>
	 * 3. " " is NOT blank <br>
	 * <p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(final String str) {
		return (str == null || "".equals(str));
	}

	/**
	 * determine string is number format or not
	 * <p>
	 * only support range Long.MIN_VALUE ~ Long.MAX_VALUE <br>
	 * <p>
	 * 
	 * @param sNumber
	 * @return
	 */
	public static boolean isNumber(final String sNumber) {
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

	/**
	 * count string length
	 * <p>
	 * if string is null then return 0
	 * <p>
	 * 
	 * @param str
	 * @return
	 */
	public static int length(final String str) {
		return str == null ? 0 : str.length();
	}

	/**
	 * trim string
	 * <p>
	 * if string is null then return ""
	 * <p>
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(final String str) {
		return (str == null) ? "" : str.trim();
	}

}
