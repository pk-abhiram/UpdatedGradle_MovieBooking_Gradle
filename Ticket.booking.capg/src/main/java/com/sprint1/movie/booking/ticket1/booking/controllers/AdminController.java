package com.sprint1.movie.booking.ticket1.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.ticket1.booking.entities.Admin;
import com.sprint1.movie.booking.ticket1.booking.exceptions.AdminNotExistsException;
import com.sprint1.movie.booking.ticket1.booking.repository.AdminRepository;
import com.sprint1.movie.booking.ticket1.booking.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@RestController
@RequestMapping("/admin")
@Api(value = "Admin", tags = { "AdminAPI" })
public class AdminController {

		
		@Autowired
		AdminService ad;
		
		//adding a new admin
		@PostMapping("/addadmin")
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity<Admin> addAdmin(@RequestBody Admin a) {
			ResponseEntity<Admin>re;
			
				Admin admin=ad.addAdmin(a);
				re=new ResponseEntity<>(admin, HttpStatus.CREATED);
			
			return re;
		}
		

    //Viewing all the admins		
		@GetMapping("/")
		public ResponseEntity<List<Admin>> findAllAdmins(){
			ResponseEntity<List<Admin>>re;
			List<Admin>admins=ad.viewAllAdmin();
			
				re=new ResponseEntity<>(admins, HttpStatus.CREATED);
			
			return re;
		}
	
		// Update admin details 
		
		@PutMapping("/")
		public ResponseEntity<Void> updateAdmin(@RequestBody Admin a) {
			ResponseEntity<Void>re;
			
				ad.updateAdmin(a);
				re=new ResponseEntity<>(HttpStatus.OK);
			return re;
		}
		
		//View admin by Id
		@GetMapping("/{id}")
		@ResponseStatus(value = HttpStatus.OK)
		public ResponseEntity<Admin> viewAdminById(@PathVariable("id") int id) {
			ResponseEntity<Admin>re;
			
			Admin findAdmin=ad.viewAdminById(id);
				re=new ResponseEntity<>(findAdmin,HttpStatus.OK);
			
			return re;
		}
		
		
		//View admin by admin name and contact
		@GetMapping("/admins/{adminName}/{adminContact}")
		public ResponseEntity<Admin> findAdminByAdminNameAndAdminContact(@PathVariable("adminName") String adminName , @PathVariable("adminContact") String adminContact){
			ResponseEntity<Admin>re;
			Admin a = ad.ByAdminNameAndAdminContact(adminName, adminContact);
			re=new ResponseEntity<>(a,HttpStatus.OK);
		 return re;
		}
		
		
		//Deleting a admin by Id
		@DeleteMapping("/deleteadmin/{id}")
		public ResponseEntity<Void> deleteAdmin(@PathVariable("id") int id) {
			ResponseEntity<Void>re;
			Optional<Admin> admin=ad.findByAdminId(id);
			if(admin.isPresent()) {
			 ad.deleteAdmin(id);;
				re=new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				throw new AdminNotExistsException("Admin with id:"+id+" not exists");
			}
			 return re;
		}



}