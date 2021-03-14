package com.sprint1.movie.booking.ticket1.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class SeatNotExistsException extends RuntimeException{

	public SeatNotExistsException() {
		super();
	}

	public SeatNotExistsException(String message) {
		super(message);
	}
	
	

}
