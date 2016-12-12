package com.github027.core.exception;

/**
 * Not support exception
 *
 */
@SuppressWarnings("serial")
public class NotSupportException extends RuntimeException {

	public NotSupportException() {
        super();
    }
	
    public NotSupportException(String message) {
        super(message);
    }

}
