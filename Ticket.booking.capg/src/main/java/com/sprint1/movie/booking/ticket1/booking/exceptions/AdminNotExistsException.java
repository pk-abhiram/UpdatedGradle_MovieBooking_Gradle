package com.sprint1.movie.booking.ticket1.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AdminNotExistsException extends RuntimeException{

	public AdminNotExistsException() {
		super();
	}

	public AdminNotExistsException(String message) {
		super(message);
	}
}
