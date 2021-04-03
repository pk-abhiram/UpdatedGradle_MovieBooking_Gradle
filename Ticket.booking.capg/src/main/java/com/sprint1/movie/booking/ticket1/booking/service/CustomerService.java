package com.sprint1.movie.booking.ticket1.booking.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Customer;
import com.sprint1.movie.booking.ticket1.booking.entities.TicketBooking;

@Component
public interface CustomerService {

	@Transactional
	public List<Customer> viewAllCustomer();
	public Customer viewCustomerById(int id);
	public List<Customer> deleteCustomer(int id);
	public Customer updateCustomer(Customer c);
	public Customer addCustomerAndTicket(int id,List<TicketBooking> ticket);
	public void deleteCustomerandTicket(int id,int ticketId);
	public Customer addCustomer(Customer c);

}