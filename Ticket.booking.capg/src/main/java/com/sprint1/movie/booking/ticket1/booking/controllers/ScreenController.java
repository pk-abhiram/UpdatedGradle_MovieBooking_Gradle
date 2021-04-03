package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Admin;
import com.sprint1.movie.booking.ticket1.booking.entities.Screen;
import com.sprint1.movie.booking.ticket1.booking.repository.ScreenRepository;
import com.sprint1.movie.booking.ticket1.booking.repository.TheatreRepository;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.ScreenServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Screen", tags = { "ScreenAPI" })
@CrossOrigin(origins = "*")
@RequestMapping(value = "/screen")
public class ScreenController {
	static final org.slf4j.Logger log = LoggerFactory.getLogger(ScreenController.class);
	@Autowired
	ScreenServiceImplementation screenServiceImplementation;
	
	@Autowired
	ScreenRepository screenRepository;
	
	@Autowired
	TheatreRepository theatreRepository; 
	
	@PostMapping(value="/")
	@ApiOperation(value = "Add a screen", notes = "Provide screen details", response = Screen.class)
	public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
		ResponseEntity<Screen>  re;
			Screen s=screenServiceImplementation.addScreen(screen);
			 re = new ResponseEntity<>(s,HttpStatus.CREATED);
			 log.info(re+"");
		return re;
	}

	@PutMapping(value="/")

	@ApiOperation(value = "Update the screen values", notes = "", response = Screen.class)
	@Transactional
	public ResponseEntity<Void> updateScreen(@RequestBody Screen screen) {
		ResponseEntity<Void>  re;
		
			screenServiceImplementation.updateScreen(screen);
			re=new ResponseEntity<>(HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	

	@DeleteMapping(value="/id/{screenId}")
	@ApiOperation(value = "Delete a Screen", notes = "Provide screen id", response = Screen.class)
	public ResponseEntity<Void> removeScreenById(@PathVariable("screenId") int screenId) {
		ResponseEntity<Void>  re;
		screenServiceImplementation.removeScreen(screenId);
		re=new ResponseEntity<>(HttpStatus.OK);
		 log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/{screenId}")
	@ApiOperation(value = "View a screen in a theatre by screen's id", notes = "Provide screen id", response = Screen.class)
	public ResponseEntity<Screen> viewScreenById(@PathVariable("screenId") int screenId){
		ResponseEntity<Screen>  re;
		Screen findScreen=screenServiceImplementation.viewScreenById(screenId);
			re = new ResponseEntity<>(findScreen,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	@GetMapping(value="/")
	@ApiOperation(value = "View all screens in a theatre",response = Screen.class)
	public ResponseEntity<List<Screen>> viewScreenListAll(){
		ResponseEntity<List<Screen>> re;
		List<Screen>screens=screenServiceImplementation.viewScreenListAll();
			re = new ResponseEntity<>(screens,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	
	@GetMapping(value="/theatre/{theatreId}")
	@ApiOperation(value = "View a screen in a theatre by theatre's id", notes = "", response = Screen.class)
	public ResponseEntity<List<Screen>> viewScreenByTheatreId(@PathVariable("theatreId") int theatreId){
		ResponseEntity<List<Screen>>  re;
		List<Screen>screens=screenServiceImplementation.viewScreenList(theatreId);
			re = new ResponseEntity<>(screens,HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
	
	@DeleteMapping(value="/show/{screenId}and{showId}")
	@ApiOperation(value = "delete show in a screen", notes = "input: screenId and showId", response = Screen.class)
	public ResponseEntity<List<Screen>> deleteScreenByShowId(@PathVariable("screenId") int screenId,@PathVariable("showId") int showId){
		ResponseEntity<List<Screen>>  re;
		screenServiceImplementation.deleteShowById(screenId, showId);
			re = new ResponseEntity<>(HttpStatus.OK);
			 log.info(re+"");
		return re;
	}
}
