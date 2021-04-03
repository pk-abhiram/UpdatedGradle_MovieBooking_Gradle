package com.sprint1.movie.booking.ticket1.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint1.movie.booking.ticket1.booking.entities.Ticket;
import com.sprint1.movie.booking.ticket1.booking.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
}
