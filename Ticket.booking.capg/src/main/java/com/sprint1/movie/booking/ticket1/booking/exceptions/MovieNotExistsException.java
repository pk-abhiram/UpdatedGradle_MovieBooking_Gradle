package com.sprint1.movie.booking.ticket1.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class MovieNotExistsException extends RuntimeException{

	public MovieNotExistsException() {
		super();
	}

	public MovieNotExistsException(String message) {
		super(message);
	}

	
	
}
