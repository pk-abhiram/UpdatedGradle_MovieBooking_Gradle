package com.sprint1.movie.booking.ticket1.booking.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel("List of Tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	@Column(nullable = false)
	private int noOfSeats;
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Seat> seats;

	@OneToOne(targetEntity = TicketBooking.class)
	private TicketBooking bookingRef;
	private boolean ticketStatus;

	public Ticket() {

	}
	
	public Ticket(int noOfSeats, List<Seat> seats, TicketBooking bookingRef) {

		this.noOfSeats = noOfSeats;
		this.seats = seats;
		this.bookingRef = bookingRef;		
	}
	
	

	public Ticket(int ticketId, int noOfSeats, List<Seat> seats, TicketBooking bookingRef, boolean ticketStatus) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seats = seats;
		this.bookingRef = bookingRef;
		this.ticketStatus = ticketStatus;
	}

	public int getTicketId() {
		return ticketId;
	}

	

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public TicketBooking getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(TicketBooking bookingRef) {
		this.bookingRef = bookingRef;
	}

	public boolean isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId  +", noOfSeats=" + noOfSeats 
				+ ", bookingRef=" + bookingRef + ", ticketStatus=" + ticketStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result + ((bookingRef == null) ? 0 : bookingRef.hashCode());
		result = prime * result + noOfSeats;
		result = prime * result + (ticketStatus ? 1231 : 1237);
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
		Ticket other = (Ticket) obj;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (bookingRef == null) {
			if (other.bookingRef != null)
				return false;
		} else if (!bookingRef.equals(other.bookingRef))
			return false;
		if (noOfSeats != other.noOfSeats)
			return false;
		if (ticketStatus != other.ticketStatus)
			return false;
		return true;
	}


}