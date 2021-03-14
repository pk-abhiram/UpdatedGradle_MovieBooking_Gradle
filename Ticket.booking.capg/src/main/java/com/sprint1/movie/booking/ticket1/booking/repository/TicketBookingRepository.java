package com.sprint1.movie.booking.ticket1.booking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.movie.booking.ticket1.booking.entities.TicketBooking;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer>{
	
	public TicketBooking findByTicketId(int ticketId);
	
	public List<TicketBooking> findByTransactionIdAndTicketId(int transactionId,int ticketId);

	public TicketBooking findByTransactionIdAndTransactionStatus(int transactionId, String transactionStatus);
	
	public List<TicketBooking> findByBookingDate(LocalDate bookingDate);
	public List<TicketBooking> findByShowId(int showId);
}