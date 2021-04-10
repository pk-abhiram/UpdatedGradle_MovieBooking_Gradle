package com.sprint1.movie.booking.ticket1.booking.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "Feedback")
@ApiModel("List of FeedBack")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //Fields
	private int feedbackId;
	
	
	private int custId;
	private int rating;
	private String feedback;
	
	
	public Feedback(int feedbackId, int custId, int rating, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.custId = custId;
		this.rating = rating;
		this.feedback = feedback;
	}




	public Feedback(int custId, int rating, String feedback) {
		super();
		this.custId = custId;
		this.rating = rating;
		this.feedback = feedback;
	}




	public Feedback() {
		super();
		
	}




	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}


	
	

}
