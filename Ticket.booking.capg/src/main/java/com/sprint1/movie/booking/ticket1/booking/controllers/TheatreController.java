package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Theatre;
import com.sprint1.movie.booking.ticket1.booking.repository.TheatreRepository;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.TheatreServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Theatre", tags = { "TheatreAPI" })
@RequestMapping(value = "/theatre")
public class TheatreController {
	static final org.slf4j.Logger log = LoggerFactory.getLogger(TheatreController.class);
	@Autowired
	TheatreServiceImplementation theatreServiceImplementation;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@PostMapping(value="/")
	@ApiOperation(value = "Add a theatre", notes = "Provide theatre details", response = Theatre.class)
	public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
		ResponseEntity<Theatre>  re;
			Theatre getTheatre=theatreServiceImplementation.addTheatre(theatre);
			 re = new ResponseEntity<>(getTheatre,HttpStatus.CREATED);
			 log.info(re+"");
		return re;
	}
	
	@PutMapping(value="/" )
	@ApiOperation(value = "Update a theatre's details", notes = "Provide theatre id, new manager contact, manager name, theatre city, theatre name or else give null", response = Theatre.class)
	@Transactional
	public ResponseEntity<Void> updateTheatre(@RequestBody Theatre theatre) {
		ResponseEntity<Void>  re;
			theatreServiceImplementation.updateTheatre(theatre);
			re=new ResponseEntity<>(HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	
	
	@DeleteMapping(value="/id/{theatreId}")
	@ApiOperation(value = "Reamove a theatre by its id", notes = "Provide theatre id", response = Theatre.class)
	public ResponseEntity<Void> removeTheatreById(@PathVariable("theatreId") int theatreId) {
		ResponseEntity<Void>  re;
		
		theatreServiceImplementation.removeTheatre(theatreId);
		re=new ResponseEntity<>(HttpStatus.OK);
		 log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/{theatreId}")
	@ApiOperation(value = "View a Theatre by its id", notes = "Provide theatre id", response = Theatre.class)
	public ResponseEntity<Theatre> viewTheatreById(@PathVariable("theatreId") int theatreId){
		ResponseEntity<Theatre>  re;
		Theatre findTheatre=theatreServiceImplementation.viewTheatreById(theatreId);
			re = new ResponseEntity<>(findTheatre,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/")
	@ApiOperation(value = "View all theatres", response = Theatre.class)
	public ResponseEntity<List<Theatre>> viewTheatreListAll(){
		ResponseEntity<List<Theatre>> re;
		List<Theatre>theatres=theatreServiceImplementation.viewTheatreList();
			re = new ResponseEntity<>(theatres,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/city/{city}")
	@ApiOperation(value = "View theatres in a city", notes = "Provide city name", response = Theatre.class)
	public ResponseEntity<List<Theatre>> viewTheatreListByCity(@PathVariable("city") String city){
		ResponseEntity<List<Theatre>>  re;
		List<Theatre> findTheatre=theatreServiceImplementation.viewTheatreListByCity(city);
			re = new ResponseEntity<>(findTheatre,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	
}
