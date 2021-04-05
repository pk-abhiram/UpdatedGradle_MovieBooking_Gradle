package com.sprint1.movie.booking.ticket1.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.movie.booking.ticket1.booking.entities.Admin;

@Repository

public interface AdminRepository extends JpaRepository<Admin,Integer> {
	//Service methods declaration

	public Admin findByAdminNameAndAdminContact(String adminName, String adminContact);
	public Admin findByEmail(String email);
}