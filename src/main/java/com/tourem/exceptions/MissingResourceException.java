package com.tourem.exceptions;

public class MissingResourceException extends RuntimeException {
	public MissingResourceException(String message, Throwable ex) {
		super(message, ex);
	}

	public MissingResourceException(String message) {
		super(message);
	}
}
