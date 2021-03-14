package com.sprint1.movie.booking.ticket1.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.movie.booking.ticket1.booking.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
