package com.sprint1.movie.booking.ticket1.booking.exceptions;

public class TheatreNotExistsException extends RuntimeException{

	public TheatreNotExistsException() {
		super();
	}
	
	public TheatreNotExistsException(String message) {
		super(message);
	}

}
