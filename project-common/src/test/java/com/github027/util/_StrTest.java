package com.github027.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github027.core.enums.YesNo;
import com.github027.util._Str;

public class _StrTest {

	@Test
	public void testConcats() {
		String result = null;

		result = _Str.concats().toString();
		assertEquals("", result);

		Object nullObj = null;
		result = _Str.concats(nullObj).toString();
		assertEquals("", result);

		result = _Str.concats(1).toString();
		assertEquals("1", result);

		result = _Str.concats(1, null, " B ", 3).toString();
		assertEquals("1 B 3", result);

		result = _Str.concats(1, null, YesNo.Y, 3).toString();
		assertEquals("1Y3", result);
	}

	@Test
	public void testIsBlank() {
		boolean result;

		result = _Str.isBlank(null);
		assertEquals(true, result);

		result = _Str.isBlank("");
		assertEquals(true, result);

		result = _Str.isBlank(" ");
		assertEquals(true, result);

		result = _Str.isBlank("   ");
		assertEquals(true, result);
	}

	@Test
	public void testIsEmpty() {
		boolean result;

		result = _Str.isEmpty(null);
		assertEquals(true, result);

		result = _Str.isEmpty("");
		assertEquals(true, result);

		result = _Str.isEmpty(" ");
		assertEquals(false, result);

		result = _Str.isEmpty("   ");
		assertEquals(false, result);
	}

	@Test
	public void testIsNumber() {
		boolean result;

		result = _Str.isNumber(null);
		assertEquals(false, result);

		result = _Str.isNumber("");
		assertEquals(false, result);

		result = _Str.isNumber(" ");
		assertEquals(false, result);

		result = _Str.isNumber("12345");
		assertEquals(true, result);

		result = _Str.isNumber("12345.00");
		assertEquals(false, result);

		result = _Str.isNumber("-12345");
		assertEquals(true, result);

		result = _Str.isNumber("0");
		assertEquals(true, result);

		result = _Str.isNumber("-0");
		assertEquals(true, result);

		result = _Str.isNumber("+0");
		assertEquals(true, result);
	}

	@Test
	public void testLength() {
		int result = 0;

		result = _Str.length(null);
		assertEquals(0, result);

		result = _Str.length("");
		assertEquals(0, result);

		result = _Str.length("123");
		assertEquals(3, result);

		result = _Str.length(" 456 ");
		assertEquals(5, result);
	}

	@Test
	public void testTrim() {
		String result = null;

		result = _Str.trim(null);
		assertEquals("", result);

		result = _Str.trim("");
		assertEquals("", result);

		result = _Str.trim(" ");
		assertEquals("", result);

		result = _Str.trim(" 1");
		assertEquals("1", result);

		result = _Str.trim("2 ");
		assertEquals("2", result);

		result = _Str.trim(" 3 ");
		assertEquals("3", result);
	}

}
