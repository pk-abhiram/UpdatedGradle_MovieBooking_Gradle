package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.movie.booking.ticket1.booking.entities.Ticket;
import com.sprint1.movie.booking.ticket1.booking.exceptions.TicketNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.TicketRepository;
import com.sprint1.movie.booking.ticket1.booking.service.TicketService;

@Service
public class TicketServiceImplementation implements TicketService{

	@Autowired
	TicketRepository ticketRepository;

	public Ticket addTicket(Ticket ticket) {
		
		return	ticketRepository.save(ticket);
		
		
	}

	@Transactional
	public Ticket updateTicket(Ticket ticket) {
		Optional<Ticket> getUpdateTicket = ticketRepository.findById(ticket.getTicketId());
		Ticket updateTicket = null;
		if(getUpdateTicket.isPresent()) {
			updateTicket = getUpdateTicket.get();
			if(ticket.getBookingRef()!=null) {
				updateTicket.setBookingRef(ticket.getBookingRef());
			}
			if(ticket.getSeats()!=null) {
				updateTicket.setSeats(ticket.getSeats());
			}
			if(ticket.getNoOfSeats()!=0) {
				updateTicket.setNoOfSeats(ticket.getNoOfSeats());
			}
	
			updateTicket.setTicketStatus(ticket.isTicketStatus());
			
		}
		else {
			throw new TicketNotExistsException("Ticket Not Exist with ID : " + ticket.getTicketId());
		}
		return ticket;
	}

	public Ticket cancelTicket(int id) {
		Optional<Ticket> findTicket = ticketRepository.findById(id);
		Ticket ticket=null;
		if(findTicket.isPresent()) {
			ticket=findTicket.get();
			ticketRepository.delete(ticket);
		}
		else {
			throw new TicketNotExistsException("Ticket Not Exist with ID : "+id);
		}
		return ticket;

	}

	public Ticket viewTicket(int ticketId) {
		Optional<Ticket> findTicket = ticketRepository.findById(ticketId);
		if(findTicket.isPresent()) {
			return findTicket.get();
		}
		else {
			throw new TicketNotExistsException("Ticket Not Exist with ID : " + ticketId);
		}
	
	}

	public List<Ticket> viewTicketList(){
		return ticketRepository.findAll();
	}

	@Override
	public Ticket cancelTicket(Ticket ticket) {
		
		Optional<Ticket> findTicket = ticketRepository.findById(ticket.getTicketId());
		Ticket cancelTicket=null;
		if(findTicket.isPresent()) {
			cancelTicket=findTicket.get();
			ticketRepository.delete(cancelTicket);
		}
		else {
			throw new TicketNotExistsException("Ticket Not Exist with ID : " + ticket.getTicketId());
		}
		return cancelTicket;
	}

}