package com.tourem.exceptions;

import com.tourem.dto.TouremErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class TouremExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {MissingResourceException.class})
	protected ResponseEntity<Object> handleMissingResource(RuntimeException e) {
		return createResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	protected ResponseEntity<Object> handleResourceNotFound(RuntimeException e) {
		return createResponse(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {IllegalArgumentException.class})
	protected ResponseEntity<Object> handleIllegalArgument(RuntimeException e) {
		return createResponse(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleGeneralException(Exception e) {
		return createResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}

	private ResponseEntity<Object> createResponse(String message, HttpStatus status) {
		Map<String, String> response = Map.of(
			"timestamp", LocalDateTime.now().toString(),
			"message", message
		);
		return new ResponseEntity<>(new TouremErrorResponse<>(response, status.value()), status);
	}
}
