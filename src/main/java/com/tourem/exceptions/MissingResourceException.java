package com.tourem.exceptions;

public class MissingResourceException extends RuntimeException {
	public MissingResourceException(String message, Throwable ex) {
		super(message, ex);
	}
}
