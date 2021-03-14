package com.sprint1.movie.booking.ticket1.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class BookingNotExistsException extends RuntimeException{

	public BookingNotExistsException() {
		super();	}

	public BookingNotExistsException(String message) {
		super(message);
	}

	
}
