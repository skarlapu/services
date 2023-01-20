package com.learner.exception;

public class ProductIsNotInStock extends RuntimeException {
	public ProductIsNotInStock(String message) {
		super(message);
	}

}
