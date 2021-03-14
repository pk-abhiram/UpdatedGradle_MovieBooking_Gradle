package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import com.sprint1.movie.booking.ticket1.booking.Application;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.exceptions.ShowNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.ScreenRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.ShowRepository;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.ShowServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Show", tags = { "ShowAPI" })
@RequestMapping(value = "/show")
public class ShowController {

	static final org.slf4j.Logger log = LoggerFactory.getLogger(ShowController.class);
	@Autowired
	ShowServiceImplementation showServiceImplementation;
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	ScreenRepository screenRepository;
	
	@PostMapping(value="/")
	@ApiOperation(value = "Add a show", notes = "Provide show details", response = Show.class)
	public ResponseEntity<Show> addShow(@RequestBody Show show) {
		ResponseEntity<Show>  re;
		Show getShow=showServiceImplementation.addShow(show);
		re=new ResponseEntity<>(getShow,HttpStatus.CREATED);
		log.info(re+"");
		return re;
	}
	
	@PutMapping(value="/" )
	@ApiOperation(value = "Update a show's details", notes = "Provide show id, new screen id,show end time, show start time, show name,theatre id, movie id", response = Show.class)
	@Transactional
	public ResponseEntity<Show> updateShow(@RequestBody Show show) {
		ResponseEntity<Show>  re;
		Optional<Show> findShow = showRepository.findById(show.getShowId());
		if(findShow.isPresent()) {
		Show getShow=showServiceImplementation.updateShow(show);
			re=new ResponseEntity<>(getShow,HttpStatus.OK);
		}
		else {
			throw new ShowNotExistsException("Show not exist with Id: " +  show.getShowId());
		}
		log.info(re+"");
		return re;
	}
	
	@DeleteMapping(value="/")
	@ApiOperation(value = "Delete a show", notes = "Provide show details", response = Show.class)
	public ResponseEntity<Show> removeShow(@RequestBody Show show) {
		Show removeShow=showServiceImplementation.removeShow(show);
		ResponseEntity<Show>  re;
		re=new ResponseEntity<>(removeShow,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(value="/{show}")
	public ResponseEntity<Show> viewShow(@PathVariable("show") Show show){
		ResponseEntity<Show>  re;
		Show findShow=showServiceImplementation.viewShow(show);
			re = new ResponseEntity<>(findShow,HttpStatus.FOUND);
			log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/{showId}")
	@ApiOperation(value = "View a screen by id", notes = "Provide show id", response = Show.class)
	public ResponseEntity<Show> viewScreenById(@PathVariable("showId") int showId){
		ResponseEntity<Show>  re;
		Show findShow=showServiceImplementation.viewShowById(showId);
		
			re = new ResponseEntity<>(findShow,HttpStatus.FOUND);
			log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/theatre/{theatreId}")
	@ApiOperation(value = "View a screen using theatre id", notes = "Provide theatre id", response = Show.class)
	public ResponseEntity<List<Show>> viewScreenBytheatreId(@PathVariable("theatreId") int theatreId){
		ResponseEntity<List<Show>>  re;
		List<Show> findShow=showServiceImplementation.viewShowList(theatreId);
		
			re = new ResponseEntity<>(findShow,HttpStatus.FOUND);
			log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/LocalDate/{date}")
	@ApiOperation(value = "View screens available on a perticular day", notes = "Provide date", response = Show.class)
	public ResponseEntity<List<Show>> viewScreenByDate(@PathVariable("date") @DateTimeFormat(iso=ISO.DATE)  LocalDate date){
		ResponseEntity<List<Show>>  re;
		List<Show> findShow=showServiceImplementation.viewShowList(date);
		
			re = new ResponseEntity<>(findShow,HttpStatus.FOUND);
			log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/")
	@ApiOperation(value = "View all screens", response = Show.class)
	public ResponseEntity<List<Show>> viewScreensAll(){
		ResponseEntity<List<Show>>  re;
		List<Show> findShow=showServiceImplementation.viewAllShows();
		
			re = new ResponseEntity<>(findShow,HttpStatus.FOUND);
			log.info(re+"");
		return re;
	}
	
	
}
