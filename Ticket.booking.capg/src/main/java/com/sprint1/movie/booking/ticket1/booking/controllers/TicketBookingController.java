package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Customer;
import com.sprint1.movie.booking.ticket1.booking.entities.TicketBooking;
import com.sprint1.movie.booking.ticket1.booking.repository.TicketBookingRepository;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.TicketBookingServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "TicketBooking", tags = { "TicketBookingAPI" })
@CrossOrigin(origins = "*")
@RequestMapping(value = "Booking")
public class TicketBookingController {

	static final org.slf4j.Logger log = LoggerFactory.getLogger(TicketBookingController.class);
	@Autowired
	TicketBookingRepository ticketBookingRepository;
	
	@Autowired
	TicketBookingServiceImplementation ticketBookingServiceImplementation; 
	
	@PostMapping("/")
	@ApiOperation(value = "Book a new ticket", notes = "Provide ticket details", response = TicketBooking.class)
	public ResponseEntity<TicketBooking> addBooking(@RequestBody TicketBooking booking){
		ResponseEntity<TicketBooking> re;
				
			
		ticketBookingServiceImplementation.addBooking(booking);

		re = new ResponseEntity<>(booking, HttpStatus.CREATED);
		log.info(re+"");
		return re;
	}
	
	@PutMapping(value = "/")
	@ApiOperation(value = "Update a ticket booking details", notes = "Provide ticket id, new details else add null", response = TicketBooking.class)
	@Transactional
	public ResponseEntity<Void> updateTicketBooking(@RequestBody TicketBooking booking){
		ResponseEntity<Void> re;
		
			ticketBookingServiceImplementation.updateBooking(booking);
			re = new ResponseEntity<>( HttpStatus.CREATED);
			log.info(re+"");
			return re;
	}
	
	@DeleteMapping("/delete/{custid}/{ticketid}")
	@ApiOperation(value = "Cancel a booking", notes = "Provide ticket details", response = TicketBooking.class)
	public ResponseEntity<Customer> cancelBooking(@PathVariable("custid") int custid,@PathVariable("ticketid") int ticketid) {
		ResponseEntity<Customer> re;
		
		Customer newCust=ticketBookingServiceImplementation.cancelBooking(custid,ticketid);
			
			re = new ResponseEntity<>(newCust,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	

	@GetMapping("/bookingsByDate/{date}")
	@ApiOperation(value = "View a ticket bookings on a perticular day", notes = "Provide date", response = TicketBooking.class)
	public ResponseEntity<List<TicketBooking>> viewBookingByDate(@PathVariable("date") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  date) {

		ResponseEntity<List<TicketBooking>> re;
		List<TicketBooking> bookings = ticketBookingServiceImplementation.showAllBookingByDate(date);
		  re =  new ResponseEntity<>(bookings,HttpStatus.OK);
		  log.info(re+"");
		  return  re ;
	}
	
	@GetMapping("/M/{movieId}")
	@ApiOperation(value = "View ticket bookings for a movie", notes = "Provide movie id", response = TicketBooking.class)
	public ResponseEntity<List<TicketBooking>> findByMovieId(@PathVariable ("movieId") int movieId) {
		ResponseEntity<List<TicketBooking>> re;
		List<TicketBooking>ticketBookings=ticketBookingServiceImplementation.showAllBooking(movieId);
		
			re=new ResponseEntity<>(ticketBookings,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	
	@GetMapping("/{ticketId}")
	@ApiOperation(value = "View a ticket booking using ticket id", notes = "Provide ticket id", response = TicketBooking.class)
	public ResponseEntity<List<TicketBooking>> findByTicketId(@PathVariable ("ticketId") int ticketId) {
		ResponseEntity<List<TicketBooking>> re;
		List<TicketBooking>ticketBookings=ticketBookingServiceImplementation.showAllBooking(ticketId);
		
			re=new ResponseEntity<>(ticketBookings,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	
	@GetMapping("/S/{showId}")
	@ApiOperation(value = "View ticket bookings for a perticular show", notes = "Provide show id", response = TicketBooking.class)
	public ResponseEntity<List<TicketBooking>> findByShowId(@PathVariable ("showId") int showId) {
		ResponseEntity<List<TicketBooking>> re;
		List<TicketBooking>ticketBookings=ticketBookingServiceImplementation.showBookingList(showId);
		
		
			re=new ResponseEntity<>(ticketBookings,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
		
	@GetMapping("/")
	@ApiOperation(value = "View all ticket bookings", response = TicketBooking.class)
	public ResponseEntity<List<TicketBooking>> viewAllBookings(){
		ResponseEntity<List<TicketBooking>> re;
		List<TicketBooking> tickets = ticketBookingServiceImplementation.showAllBookings();
		
			re = new ResponseEntity<>(tickets,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	
	@GetMapping("/total/{id}")
	@ApiOperation(value = "View a ticket booking by its id", notes = "Provide ticket booking id", response = TicketBooking.class)
	public ResponseEntity<Double> findByticketId(@PathVariable("id") int bookingId) {
		ResponseEntity<Double> re = null;
		
		
			Double cost=ticketBookingServiceImplementation.calculateTotalCost(bookingId);
			re = new ResponseEntity<>(cost,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	
}
	
	