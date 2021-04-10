package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.movie.booking.ticket1.booking.entities.Feedback;
import com.sprint1.movie.booking.ticket1.booking.repository.FeedbackRepository;
import com.sprint1.movie.booking.ticket1.booking.service.FeedbackService;

@Service
public class FeedbackServiceImplementation implements FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	
	
	//Adding a Feedback
	public void addFeedback(Feedback feedback)   {
		feedbackRepository.save(feedback);
	}
	
	
	
}