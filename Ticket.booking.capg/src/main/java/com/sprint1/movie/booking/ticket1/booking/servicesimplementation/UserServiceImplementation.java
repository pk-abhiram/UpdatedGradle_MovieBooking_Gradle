package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.movie.booking.ticket1.booking.entities.User;
import com.sprint1.movie.booking.ticket1.booking.repository.UserRepository;
import com.sprint1.movie.booking.ticket1.booking.service.UserService;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository userRepository;

	Optional<User> users = null;

	//Adding a User
	public User addUser(User u) {
		users = userRepository.findById(u.getUserId());
		if(users.isEmpty()) {
			userRepository.save(u);
		}
		return null;
	}

}
