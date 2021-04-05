package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.User;
import com.sprint1.movie.booking.ticket1.booking.service.UserService;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.UserServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "User", tags = { "UserAPI" })
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	static final org.slf4j.Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService us;

	@Autowired
	UserServiceImplementation userServiceImplementation; 
	
	//adding a new user
	@PostMapping("/adduser")
	@ApiOperation(value = "Add a user", notes = "Provide user details", response = User.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<User> addUser(@RequestBody User u) {
		ResponseEntity<User>re;

		us.addUser(u);
		re=new ResponseEntity<>(u, HttpStatus.CREATED);
		log.info(re+"");
		return re;

	}

	//Deleting a user by id
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a User", notes = "Provide User id", response = User.class)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		ResponseEntity<Void>re;

		us.deleteUser(id);
		re=new ResponseEntity<>(HttpStatus.OK);
		log.info(re+"");
		return re;
	}

	@PostMapping("/finduser")
	@ApiOperation(value = "Find a user", notes = "Find user email", response = User.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<User> findUser(@RequestBody User user) {
		ResponseEntity<User>re;
		
		User getUser=userServiceImplementation.findByEmail(user.getEmail());
		re=new ResponseEntity<>(getUser, HttpStatus.CREATED);
		log.info(re+"");
		return re;

	}




}