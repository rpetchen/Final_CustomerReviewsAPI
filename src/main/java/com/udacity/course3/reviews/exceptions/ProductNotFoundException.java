package com.udacity.course3.reviews.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {

	}

	public ProductNotFoundException(String message) {
		super(message);
	}
}
