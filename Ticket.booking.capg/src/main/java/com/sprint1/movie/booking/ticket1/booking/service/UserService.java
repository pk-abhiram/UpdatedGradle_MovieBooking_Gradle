package com.sprint1.movie.booking.ticket1.booking.service;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.User;


@Component
public interface UserService {
	
	

		//Methods
		@Transactional
		public void addUser(User user);
		public void deleteUser(int id);
		public Optional<User> findById(int id);

	

}
