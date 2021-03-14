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

import com.sprint1.movie.booking.ticket1.booking.entities.Seat;
import com.sprint1.movie.booking.ticket1.booking.repository.SeatRepository;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.SeatServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "Seat", tags = { "SeatAPI" })
@RequestMapping(value = "/seat")
public class SeatController {
	
	static final org.slf4j.Logger log = LoggerFactory.getLogger(SeatController.class);
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	SeatServiceImplementation seatServiceImplementation;
	
	@PostMapping("/")
	@ApiOperation(value = "Add a seat", notes = "Provide seat details", response = Seat.class)
	public ResponseEntity<Seat> addSeat(@RequestBody Seat seat){
		ResponseEntity<Seat> re;
		
		Seat getSeat=seatServiceImplementation.addSeat(seat);
		re = new ResponseEntity<>(getSeat,HttpStatus.CREATED);
		 log.info(re+"");
		return re;
	}
	
	@PutMapping(value = "/")
	@ApiOperation(value = "Update a seat's details", notes = "Provide seat id, new price, seat number, tyoe or give null", response = Seat.class)
	public ResponseEntity<Void> updateSeat(@RequestBody Seat seat){
		ResponseEntity<Void> re;
		
			seatServiceImplementation.updateSeat(seat);
			re = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 log.info(re+"");
		return re;
	}
	
	
	@GetMapping("/{seatId}")
	@ApiOperation(value = "Find your seat using ticket id", notes = "Provide ticket id", response = Seat.class)
	public ResponseEntity<Seat> findByticketId(@PathVariable int seatId){
		ResponseEntity<Seat> re;
		
			Seat seat=seatServiceImplementation.viewSeat(seatId);
			re = new ResponseEntity<>(seat,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	
	@GetMapping("/")
	@ApiOperation(value = "View all seats in a theatre", response = Seat.class)
	public ResponseEntity<List<Seat>> viewAllSeats(){
		ResponseEntity<List<Seat>> re;
		List<Seat>seats = seatServiceImplementation.viewSeatList();
		
			re = new ResponseEntity<>(seats,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a seat using seat id", notes = "Provide seat id", response = Seat.class)
	public ResponseEntity<Void> deleteSeat(@PathVariable("id") int seatId) {
		ResponseEntity<Void> re;
		
			seatServiceImplementation.removeSeat(seatId);
			re = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 log.info(re+"");
		return re;
	}
	
	@DeleteMapping("/s/")
	@ApiOperation(value = "Delete a seat", response = Seat.class)
	public ResponseEntity<Void> deleteSeat(@RequestBody Seat seat) {
		ResponseEntity<Void> re;
		
			seatServiceImplementation.removeSeat(seat.getSeatId());
			re = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 log.info(re+"");
		return re;
	}
	
	@GetMapping("/type/{type}")
	@ApiOperation(value = "View all seats by its type", notes = "Provide type of seat", response = Seat.class)
	public ResponseEntity<List<Seat>> viewAllSeatsByType(@PathVariable("type") String type){
		ResponseEntity<List<Seat>> re;
		List<Seat>seats=seatServiceImplementation.viewSeatByType(type);
		
	
			re = new ResponseEntity<>(seats,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}	
	
	
	
}