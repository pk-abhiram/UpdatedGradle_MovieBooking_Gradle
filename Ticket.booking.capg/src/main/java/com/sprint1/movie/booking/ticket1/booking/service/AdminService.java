package com.sprint1.movie.booking.ticket1.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Admin;
@Component
public interface AdminService {

	//Methods
	@Transactional
	public void addAdmin(Admin admin);
	public List<Admin> viewAllAdmin();
	public Admin viewAdminById(int id);
	public void deleteAdmin(int id);
	public Admin updateAdmin(Admin a);
	public Admin ByAdminNameAndAdminContact(String adminName, String adminContact);
	public Optional<Admin> findByAdminId(int id);
	

}