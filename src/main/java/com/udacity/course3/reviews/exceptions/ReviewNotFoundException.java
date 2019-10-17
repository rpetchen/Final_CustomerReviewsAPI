package com.udacity.course3.reviews.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Review Not Found")
public class ReviewNotFoundException extends RuntimeException {

	public ReviewNotFoundException() {

	}

	public ReviewNotFoundException(String message) {
		super(message);
	}
}
