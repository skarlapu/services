package com.learner.controlAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learner.exception.ExceptionMessage;

@RestControllerAdvice
public class ProductRestControlAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionMessage> handleRequestBodyValidationException(
			MethodArgumentNotValidException exception) {
		return new ResponseEntity<ExceptionMessage>(ExceptionMessage.builder().message(exception.getMessage()).build(),
				HttpStatus.BAD_REQUEST);
	}
}
