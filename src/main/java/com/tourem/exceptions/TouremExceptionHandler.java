package com.tourem.exceptions;

import com.tourem.dto.TouremErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class TouremExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {MissingResourceException.class})
	protected ResponseEntity<Object> handleMissingResource(RuntimeException e) {
		log.debug("[MissingResourceException] - Full exception details", e);
		return createResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	protected ResponseEntity<Object> handleResourceNotFound(RuntimeException e) {
		log.debug("[ResourceNotFoundException] - Full exception details", e);
		return createResponse(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {IllegalArgumentException.class})
	protected ResponseEntity<Object> handleIllegalArgument(RuntimeException e) {
		log.debug("[IllegalArgumentException] - Full exception details", e);
		return createResponse(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = {ResourceCreationFailedException.class})
	protected ResponseEntity<Object> handleCreationFailedException(Exception e) {
		log.debug("[ResourceCreationFailedException] - Full exception details", e);
		return createResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleGeneralException(Exception e) {
		log.debug("[Exception] - Full exception details", e);
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
