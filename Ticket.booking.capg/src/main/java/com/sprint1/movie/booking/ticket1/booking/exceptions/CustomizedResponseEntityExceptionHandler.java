package com.sprint1.movie.booking.ticket1.booking.exceptions;

import java.util.Date;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(TheatreNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(TheatreNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	
	@ExceptionHandler(UnexpectedRollbackException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(UnexpectedRollbackException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}

	

	@ExceptionHandler(ScreenNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(ScreenNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(NoSuchElementException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	
	@ExceptionHandler(ShowNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(ShowNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	
	@ExceptionHandler(SeatNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(SeatNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	

	@ExceptionHandler(TicketNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(TicketNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler(BookingNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(BookingNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	

	@ExceptionHandler(MovieNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(MovieNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler(CustomerNotExistsException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(CustomerNotExistsException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(ConstraintViolationException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public final ResponseEntity<Object> handleAlreadyExistsException(InvalidDataAccessApiUsageException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT.value(), new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	
	
}
