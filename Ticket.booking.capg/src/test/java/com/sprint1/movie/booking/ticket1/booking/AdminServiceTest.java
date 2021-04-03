package com.sprint1.movie.booking.ticket1.booking;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.sprint1.movie.booking.ticket1.booking.entities.Admin;
import com.sprint1.movie.booking.ticket1.booking.entities.User;
import com.sprint1.movie.booking.ticket1.booking.repository.UserRepository;
import com.sprint1.movie.booking.ticket1.booking.service.AdminService;
import com.sprint1.movie.booking.ticket1.booking.servicesimplementation.UserServiceImplementation;

@SpringBootTest
public class AdminServiceTest {
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@Autowired
	UserRepository userRepository;
	
//	@Test
	void testaddAdmin() {
		
		try {
			Admin admin = new Admin(1,"Chand","9899998805");
			adminService.addAdmin(admin);

		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	void testViewAdmin() {
//		int id=1;
//		Admin admin = adminService.viewAdminById(id);
//		System.out.println(admin);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		System.out.println(encoder.encode("admin"));
//		User user=new User("customer123", encoder.encode("admin"), "CUSTOMER", true);
//		userServiceImplementation.addUser(user);
//		System.out.println(userRepository.findAll());
//	}
	
//	@Test
	void testViewAllAdmins() {
		List<Admin> admins = adminService.viewAllAdmin();
		System.out.println(admins);
	}
	
//	@Test
	void testRemoveAdmin() {
		int id=5;
		adminService.deleteAdmin(id);
		System.out.println("Admin Deleted!");
	}
	
//	@Test
	void testUpdateAdmin() {
		int id=3;
		Admin admin = new Admin(3,null,null);
		adminService.updateAdmin(admin);
	}
	
}