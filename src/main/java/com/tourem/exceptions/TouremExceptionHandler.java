package com.tourem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class TouremExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {MissingResourceException.class})
	protected ResponseEntity<Object> handleMissingResource(RuntimeException e, WebRequest request) {
		return createResponse("A mandatory resource is missing", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	protected ResponseEntity<Object> handleResourceNotFound(RuntimeException e, WebRequest request) {
		return createResponse("The resource you are searching does not exist", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {IllegalArgumentException.class})
	protected ResponseEntity<Object> handleIllegalArgument(RuntimeException e, WebRequest request) {
		return createResponse("You are using an illegal resource", HttpStatus.NOT_ACCEPTABLE);
	}

	private ResponseEntity<Object> createResponse(String message, HttpStatus status) {
		Map<String, String> errResponse = Map.of(
			"timestamp", LocalDateTime.now().toString(),
			"message", message
		);
		return new ResponseEntity<>(errResponse, status);
	}
}
