package com.saicharan.shipping.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex){
		
		Map<String, Object> error = Map.of(
				"error", ex.getMessage(),
				"status", HttpStatus.BAD_REQUEST.value()
		);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}

}
