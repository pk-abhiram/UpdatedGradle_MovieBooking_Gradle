package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Ticket;
import com.sprint1.movie.booking.ticket1.booking.repository.TicketRepository;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.TicketServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Ticket", tags = { "TicketAPI" })
@RequestMapping(value = "/ticket")
public class TicketController {
	static final org.slf4j.Logger log = LoggerFactory.getLogger(TicketController.class);
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TicketServiceImplementation ticketServiceImplementation; 
	
	@PostMapping("/")
	@ApiOperation(value = "Add a ticket", notes = "Provide ticket details", response = Ticket.class)
	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
		ResponseEntity<Ticket> re;
		try {
			ticketServiceImplementation.addTicket(ticket);
		re = new ResponseEntity<>(ticket,HttpStatus.CREATED);
		return re;
		}
		catch(Exception e){
			re = new ResponseEntity<>(ticket,HttpStatus.CONFLICT);
			log.info(re+"");
			return re;
		}
		
	}
	
	@PutMapping(value = "/tickets")
	@ApiOperation(value = "Update a ticket's details", notes = "Provide ticket id, new ticket details or else give null", response = Ticket.class)
	public ResponseEntity<Void> updateTicket(@RequestBody Ticket ticket){
		ResponseEntity<Void> re;
		
			ticketServiceImplementation.updateTicket(ticket);
			re =  new ResponseEntity<>(HttpStatus.NO_CONTENT);
			log.info(re+"");
		return re;
	}
	
	@DeleteMapping(value = "/")
	@ApiOperation(value = "Delete a ticket", notes = "Provide ticket details", response = Ticket.class)
	public ResponseEntity<Void> cancelTicket(@RequestBody Ticket ticket){
		ResponseEntity<Void> re;
		
			ticketServiceImplementation.cancelTicket(ticket);
			re =  new ResponseEntity<>(HttpStatus.NO_CONTENT);
			log.info(re+"");
		return re;
	}
	
	@GetMapping("/{ticketId}")
	@ApiOperation(value = "View a ticket by its id", notes = "Provide ticket id", response = Ticket.class)
	public ResponseEntity<Ticket>  findByticketId(@PathVariable("ticketId") int ticketId){
		ResponseEntity<Ticket> re;
		
			Ticket ticket=ticketServiceImplementation.viewTicket(ticketId);
			re =  new ResponseEntity<>(ticket,HttpStatus.OK);
			log.info(re+"");
		return re;
	}
	
	@GetMapping("/")
	@ApiOperation(value = "View all tickets", response = Ticket.class)
	public ResponseEntity<List<Ticket>> findAllTickets(){
		ResponseEntity<List<Ticket>> re;
		List<Ticket> tickets = ticketServiceImplementation.viewTicketList();
		
			re =  new ResponseEntity<>(tickets,HttpStatus.OK);
			log.info(re+"");
		return re;
	}

}