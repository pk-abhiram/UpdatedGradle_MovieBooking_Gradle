package com.sprint1.movie.booking.ticket1.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.movie.booking.ticket1.booking.entities.Customer;

public interface CustomerRepostitory extends JpaRepository<Customer, Integer>{

}