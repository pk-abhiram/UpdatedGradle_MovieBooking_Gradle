package com.sprint1.movie.booking.ticket1.booking.service;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sprint1.movie.booking.ticket1.booking.entities.User;

@Component
public interface UserService {
	public User addUser(@RequestBody User u);
}
