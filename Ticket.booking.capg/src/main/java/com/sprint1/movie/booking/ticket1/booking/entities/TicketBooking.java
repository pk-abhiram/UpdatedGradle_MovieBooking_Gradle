package com.sprint1.movie.booking.ticket1.booking.entities;


import java.time.LocalDate;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel("TicketBookings")
public class TicketBooking {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	@Column(nullable = false)
	private int showId;
	
	private LocalDate bookingDate;

	
	private  int transactionId ;
	
	private String transactionMode;
	private String transactionStatus;
	private double totalCost;
	@OneToOne(cascade = CascadeType.ALL,targetEntity = Ticket.class)
	private Ticket ticket;

	
	public TicketBooking() {
		super();
	}
	

	public TicketBooking(int showId, Ticket ticket) {
		this.bookingDate = LocalDate.now();
		this.showId = showId;
		this.ticket = ticket;
		
	}

	
	
	public TicketBooking(int ticketId, int showId, int transactionId, String transactionMode,
			String transactionStatus, double totalCost, Ticket ticket) {
		super();
		this.ticketId = ticketId;
		this.showId = showId;
		this.bookingDate = LocalDate.now();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.ticket = ticket;
	}


	public TicketBooking(int showId, int transactionId, String transactionMode,
			String transactionStatus, double totalCost, Ticket ticket) {
		super();
		this.showId = showId;
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.ticket = ticket;
	}


	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "TicketBooking [ticketId=" + ticketId + ", showId=" + showId + ", bookingDate=" + bookingDate
				+ ", transactionId=" + transactionId + ", transactionMode=" + transactionMode + ", transactionStatus="
				+ transactionStatus + ", totalCost=" + totalCost + ", ticket=" + ticket + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
		result = prime * result + showId;
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + transactionId;
		result = prime * result + ((transactionMode == null) ? 0 : transactionMode.hashCode());
		result = prime * result + ((transactionStatus == null) ? 0 : transactionStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketBooking other = (TicketBooking) obj;
		if (bookingDate == null) {
			if (other.bookingDate != null)
				return false;
		} else if (!bookingDate.equals(other.bookingDate))
			return false;
		if (showId != other.showId)
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionMode == null) {
			if (other.transactionMode != null)
				return false;
		} else if (!transactionMode.equals(other.transactionMode))
			return false;
		if (transactionStatus == null) {
			if (other.transactionStatus != null)
				return false;
		} else if (!transactionStatus.equals(other.transactionStatus))
			return false;
		return true;
	}


}