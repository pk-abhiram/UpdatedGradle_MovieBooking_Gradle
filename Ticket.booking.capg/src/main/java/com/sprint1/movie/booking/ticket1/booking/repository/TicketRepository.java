package com.sprint1.movie.booking.ticket1.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.movie.booking.ticket1.booking.entities.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	public Ticket findByTicketId(int ticketId);
}