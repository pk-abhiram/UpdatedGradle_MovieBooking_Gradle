package com.sprint1.movie.booking.ticket1.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Feedback;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.FeedbackServiceImplementation;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "*")
@Api(value = "Feedback", tags = { "FeedbackAPI" })
public class FeedbackController {
	@Autowired
	FeedbackServiceImplementation feedbackServiceImplementation;
	
	//adding a new feedback
			@PostMapping("/add")
			@ResponseStatus(code = HttpStatus.CREATED)
			public ResponseEntity<Void> addFeedback(@RequestBody Feedback feedback) {
				ResponseEntity<Void>re;
				System.out.println("31"+feedback);
				feedbackServiceImplementation.addFeedback(feedback);
					
					re=new ResponseEntity<>(HttpStatus.CREATED);
				
				return re;
			}

}
