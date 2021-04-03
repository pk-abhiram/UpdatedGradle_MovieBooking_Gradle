package com.sprint1.movie.booking.ticket1.booking.servicesimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.ticket1.booking.entities.Admin;
import com.sprint1.movie.booking.ticket1.booking.entities.User;
import com.sprint1.movie.booking.ticket1.booking.exceptions.CustomerNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.AdminRepository;
import com.sprint1.movie.booking.ticket1.booking.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService {
	@Autowired
	AdminRepository iar;
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	Optional<Admin> admins = null;
	
	//Adding a Admin
	public Admin addAdmin(Admin a)   {
		System.out.println(a);
		if(userServiceImplementation.findByEmailAdmin(a.getEmail())==null) {
		User user = new User(a.getEmail(),a.getPassword(),"ADMIN");
		a.setUser(user);
			return iar.save(a);
		}
		throw new CustomerNotExistsException("Admin exists with email:"+a.getEmail());
	}
	
	//Viewing all admins
	public List<Admin> viewAllAdmin() {
		List<Admin> admins = iar.findAll();
		return admins;
	}

	//Viewing customer by id
	public Admin viewAdminById(int id) {
		
		Optional<Admin> admin = iar.findById(id);
		Admin a = null;
		if(admin.isPresent()) {
			a = admin.get();
		}
		
		return a;
	}
	
	//Deleting a customer
	public void deleteAdmin(int id){
		Optional<Admin> admin = iar.findById(id);
		Admin a = null;
		if(admin.isPresent()) {
			a = admin.get();
			iar.delete(a);
		}
//		else {
//			throw new AdminDoesNotExistException("Customer with id:"+c.getCust_id()+" does not exist");
//		}
	}

	//Update
	@Transactional
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> getAdmin = iar.findById(admin.getAdminId());
		Admin updateadmin = null;
		if(getAdmin.isPresent()) {
			updateadmin = getAdmin.get();
			if(admin.getAdminName()!=null) {
				updateadmin.setAdminName(admin.getAdminName());
			}
			if(admin.getAdminContact()!=null) {
				updateadmin.setAdminContact(admin.getAdminContact());
			}
			
		}
		return updateadmin;
	}

	public Admin ByAdminNameAndAdminContact(String adminName, String adminContact) {
		return iar.findByAdminNameAndAdminContact(adminName, adminContact);
		}

	@Override
	public Optional<Admin> findByAdminId(int id) {
		return iar.findById(id);
		
	}
	
}