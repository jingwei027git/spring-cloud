package com.github027.util;

import java.time.LocalDateTime;

public class _Sys {

	public static LocalDateTime now() {
		return LocalDateTime.now();
	}

	public static void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
