package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Customer;
import com.sprint1.movie.booking.ticket1.booking.entities.Show;
import com.sprint1.movie.booking.ticket1.booking.entities.TicketBooking;
import com.sprint1.movie.booking.ticket1.booking.entities.User;
import com.sprint1.movie.booking.ticket1.booking.exceptions.CustomerNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.CustomerRepostitory;
import com.sprint1.movie.booking.ticket1.booking.repository.TicketBookingRepository;
import com.sprint1.movie.booking.ticket1.booking.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService{
	@Autowired
	CustomerRepostitory customerRepostitory;

	@Autowired
	TicketBookingServiceImplementation ticketBookingServiceImplementation;

	@Autowired
	ShowServiceImplementation showImplementation;
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@Autowired
	TicketBookingRepository ticketBookingRepository;


	Optional<Customer> customers;

	//Adding a customer
	@Transactional
	public Customer addCustomer(Customer customer) {
		
		if(userServiceImplementation.findByEmailAdmin(customer.getEmail())==null) {
			
			User user = new User(customer.getEmail(),customer.getPassword(),"CUSTOMER");
			System.out.println(user);
			customer.setUser(user);
			customer = customerRepostitory.save(customer); 
			return customer;
		}
		throw new CustomerNotExistsException("Customer exists with email:"+customer.getEmail());
		
	}

	//Update a customer
	@Transactional
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> getCustomer = customerRepostitory.findById(customer.getCustomerId());
		Customer updatecust = null;
		if(getCustomer.isPresent()) {
			updatecust = getCustomer.get();
			if(customer.getCustomerName()!=null) {
				updatecust.setCustomerName(customer.getCustomerName());
			}
			if(customer.getAddress()!=null) {
				updatecust.setAddress(customer.getAddress());
			}
			if(customer.getEmail()!=null) {
				updatecust.setEmail(customer.getEmail());
			}
			if(customer.getMobileNo()!=null) {
				updatecust.setMobileNo(customer.getMobileNo());
			}
			if(customer.getPassword()!=null) {
				updatecust.setPassword(customer.getPassword());
				updatecust.setUser(new User(customer.getEmail(),customer.getPassword(),"Customer"));
			}
		}
		else {
			throw new CustomerNotExistsException("Customer with id:"+customer.getCustomerId()+" does not exists");
		}
		return updatecust;
	}

	//Deleting a customer
//	public Customer deleteCustomer(int id){
//		Optional<Customer> customer = customerRepostitory.findById(id);
//		Customer c = null;
//		if(customer.isPresent()) {
//			c = customer.get();
//			customerRepostitory.delete(c);
//			return c;
//		}
//		else {
//			throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
//		}
//
//	}	
	//Deleting a customer
		public List<Customer> deleteCustomer(int id){
			Optional<Customer> customer = customerRepostitory.findById(id);
			Customer c = null;
			if(customer.isPresent()) {
				c = customer.get();
				customerRepostitory.delete(c);
				return customerRepostitory.findAll();
			}
			else {
				throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
			}

		}

	//Viewing customer by id
	public Customer viewCustomerById(int id) {

		Optional<Customer> customer = customerRepostitory.findById(id);
		Customer c = null;
		if(customer.isPresent()) {
			c = customer.get();
			return c;
		}
		else {
			throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
		}

	}

	//Viewing all customers
	public List<Customer> viewAllCustomer() {
		return customerRepostitory.findAll();
	}

	//Booking a ticket with customer details
	public Customer addCustomerAndTicket(int id,TicketBooking ticket) {
		Optional<Customer> customer = customerRepostitory.findById(id);
		if(customer.isPresent()) {
			ticket.setBookingDate(LocalDate.now());
			ticket.getTicket().setTicketStatus(true);
			ticket.setTransactionId(id);
			ticket.setTransactionStatus("SUCCESS");
			Random rd = new Random();
			 int   s =  rd.nextInt() & Integer.MAX_VALUE;
			 ticket.setTransactionId(s);
				customer.get().getTicketBooking().add(ticket);
			
			return customerRepostitory.save(customer.get());
		}
		else {
			throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
		}
	}

	//Delete a ticket
	public void deleteCustomerandTicket(int id,int ticketId) {
		Optional<Customer> customer = customerRepostitory.findById(id);
		if(customer.isPresent()) {
			Customer cust = customer.get();
			if(ticketBookingServiceImplementation.showAllBookingList(ticketId)!=null && cust.getTicketBooking().get(cust.getTicketBooking().indexOf(ticketBookingServiceImplementation.showAllBookingList(ticketId)))!=null) {
				cust.getTicketBooking().remove(ticketBookingServiceImplementation.showAllBookingList(ticketId));
				
				customerRepostitory.save(cust);
			}
		}
		else {
			throw new CustomerNotExistsException("Customer with id:"+id+" does not exists");
		}

	}

	//View all customers watching a movie
	public List<Customer> viewAllCustomerInAMovie(int id) {
		List<Customer> customer = customerRepostitory.findAll();
		List<Customer> customerInAMovie = new ArrayList<>();
		List<TicketBooking> tickets = ticketBookingServiceImplementation.showAllBooking(id);
		for(Customer c:customer) {
			for(TicketBooking t:tickets) {
				Show show = showImplementation.viewShowById(t.getShowId());
				if(show.getMovie().getMovieId()==id) {
					customerInAMovie.add(c);
				}
				else {
					throw new CustomerNotExistsException("Customers do not exist in this movie.");
				}
			}	

		}
		return customerInAMovie;
	}
	public Customer viewCustomerByEmail(String email) {
			Customer customer=customerRepostitory.findByEmail(email);
				if(customer!=null) {
					return customer;
				}
				else {
					throw new CustomerNotExistsException("Customers do not exist with Email:"+email);
				}
		
		
	}














}