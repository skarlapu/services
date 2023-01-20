package com.learner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learner.exception.Exception;
import com.learner.exception.ProductIsNotInStock;

@RestControllerAdvice
public class OrderControlAdvice {
	@ExceptionHandler(ProductIsNotInStock.class)
	public ResponseEntity<Exception> handleProductNotInStockException(ProductIsNotInStock isNotInStock) {
		return new ResponseEntity<Exception>(Exception.builder().reason(isNotInStock.getMessage()).build(),
				HttpStatus.BAD_REQUEST);
	}
}
