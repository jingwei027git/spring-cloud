package com.github027.general.util;

import com.google.common.collect.Iterables;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class _Iter {

	/**
	 * get first item
	 * 
	 * @param iterable
	 * @return
	 */
	public static <T> T getFirst(final Iterable<T> iterable) {
		return (iterable == null) ? null : Iterables.getFirst(iterable, null);
	}

	/**
	 * get first item, if not exist then use default value
	 * 
	 * @param iterable
	 * @param defaultValue
	 * @return
	 */
	public static <T> T getFirst(final Iterable<T> iterable, final T defaultValue) {
		return (iterable == null) ? null : Iterables.getFirst(iterable, defaultValue);
	}

	/**
	 * get last item
	 * 
	 * @param iterable
	 * @return
	 */
	public static <T> T getLast(final Iterable<T> iterable) {
		return (iterable == null) ? null : Iterables.getLast(iterable, null);
	}

	/**
	 * get last item, if not exist then use default value
	 * 
	 * @param iterable
	 * @param defaultValue
	 * @return
	 */
	public static <T> T getLast(final Iterable<T> iterable, final T defaultValue) {
		return (iterable == null) ? null : Iterables.getLast(iterable, defaultValue);
	}

	/**
	 * count size
	 * 
	 * @param iterable
	 * @return
	 */
	public static int size(final Iterable<?> iterable) {
		return iterable == null ? 0 : Iterables.size(iterable);
	}

}
