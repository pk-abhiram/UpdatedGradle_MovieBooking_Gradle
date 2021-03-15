package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Customer;
import com.sprint1.movie.booking.ticket1.booking.repository.CustomerRepostitory;
import com.sprint1.movie.booking.ticket1.booking.service.CustomerService;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.CustomerServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Customer", tags = { "CustomerAPI" })
@RequestMapping(value = "customer")
public class CustomerController {

	@Autowired
	CustomerRepostitory customerRepository;

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerServiceImplementation customerServiceImplemntation;

	Optional<Customer> customers;


	//Adding a customer
	@PostMapping("/")
	@ApiOperation(value = "Add a Customer", notes = "Provide Cutomer details", response = Customer.class)
	public ResponseEntity<Customer> addCustomer(@ApiParam(value = "Customer to be added", required = true) @RequestBody Customer customer) {
		customerServiceImplemntation.addCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	//Update a customer 
	@PutMapping("/")
	@ApiOperation(value = "Update Customer's details",notes="Provide Customer id, new name, address, mobile number, email, password else null", response = Customer.class)
	public ResponseEntity<Void> updateCustomer(@ApiParam(value = "Customer to be Updated", required = true) @RequestBody Customer customer) {
		customerServiceImplemntation.updateCustomer(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	//Deleting a customer by id
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a Customer", notes = "Provide Customer id", response = Customer.class)
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") int id) {
		customerServiceImplemntation.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//View customer by id
	@GetMapping("/{id}")
	@ApiOperation(value = "View customer", notes = "Provide customer id", response = Customer.class)
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("id") int id) {
		Customer customer = customerServiceImplemntation.viewCustomerById(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}	

	//View all Customers
	@GetMapping("/")
	@ApiOperation(value = "View all Customers", response = Customer.class)
	public ResponseEntity<List<Customer>> viewAllCustomer() {
		List<Customer> customer = customerServiceImplemntation.viewAllCustomer();
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}	



	//Adding a customer with ticket booking
	@PostMapping("/customers/addCustomerAndTicket")
	@ApiOperation(value = "Add a customer and book a ticket", notes = "Provide customer and ticket details", response = Customer.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Customer> addCustomerAndTicket(@RequestBody Customer c) {
		Customer cust = customerServiceImplemntation.addCustomerAndTicket(c.getCustomerId(), c.getTicketBooking());
		return new ResponseEntity<>(cust, HttpStatus.CREATED);
	}

	//Deleting a Ticket
	@DeleteMapping("/{customerId}/{ticketId}")
	@ApiOperation(value = "Delete a ticket cutomer booked", notes = "Provide cutomer id and ticket id", response = Customer.class)
	public ResponseEntity<Void> deleteCustomerandTicket(@PathVariable int customerId, @PathVariable int ticketId) {
		customerServiceImplemntation.deleteCustomerandTicket(customerId, ticketId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("Movie/{id}")
	@ApiOperation(value = "View a customer watching a movie with movie id", notes = "Provide movie id", response = Customer.class)
	public ResponseEntity<List<Customer>> viewAllCustomerByMovie(@PathVariable int id) {
		List<Customer>customer = customerServiceImplemntation.viewAllCustomerInAMovie(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}	

}