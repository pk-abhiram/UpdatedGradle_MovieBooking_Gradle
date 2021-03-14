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
@Api(value = "Admin", tags = { "AdminAPI" })
@RequestMapping("/admin")
public class AdminController {
	

	static final org.slf4j.Logger log = LoggerFactory.getLogger(AdminController.class);
		@Autowired
		AdminRepository adminRepository;
		
		@Autowired
		AdminService ad;
		
		//adding a new admin
		@PostMapping("/addadmin")
		@ResponseStatus(code = HttpStatus.CREATED)
		@ApiOperation(value = "Add an admin", notes = "Provide admin details", response = Admin.class)
		public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
			ResponseEntity<Admin>re;
			
				ad.addAdmin(admin);
				re=new ResponseEntity<>(admin, HttpStatus.CREATED);
				log.info(re+"");
			return re;
		}
		

    //Viewing all the admins		
		@GetMapping("/")
		@ApiOperation(value = "View all admin", response = Admin.class)
		public ResponseEntity<List<Admin>> findAllAdmins(){
			ResponseEntity<List<Admin>>re;
			List<Admin>admins=ad.viewAllAdmin();
			
				re=new ResponseEntity<>(admins, HttpStatus.CREATED);
				log.info(re+"");
			return re;
		}
	
		//Update admin 
		
		@PutMapping("/")
		@ApiOperation(value = "Update admin's details",notes="Provide Admin id, new Admin contact,new admin name, else null", response = Admin.class)
		public ResponseEntity<Void> updateAdmin(@RequestBody Admin admin) {
			ResponseEntity<Void>re;
				ad.updateAdmin(admin);
				re=new ResponseEntity<>(HttpStatus.OK);
				log.info(re+"");
			return re;
		}
		
		//View admin by id
		@GetMapping("/{id}")
		@ApiOperation(value = "View Admin by Id", notes = "Provide admin id", response = Admin.class)
		@ResponseStatus(value = HttpStatus.OK)
		public ResponseEntity<Admin> viewAdminById(@PathVariable("id") int id) {
			ResponseEntity<Admin>re;
			
			Admin findAdmin=ad.viewAdminById(id);
				re=new ResponseEntity<>(findAdmin,HttpStatus.OK);
				log.info(re+"");
			return re;
		}
		
		
		//View adminby name and contact
		@GetMapping("/admins/{adminName}/{adminContact}")
		@ApiOperation(value = "View by admin details", notes = "Provide admin name or contact", response = Admin.class)
		public ResponseEntity<Admin> findAdminByAdminNameAndAdminContact(@PathVariable("adminName") String adminName , @PathVariable("adminContact") String adminContact){
			ResponseEntity<Admin>re;
			Admin a = ad.byAdminNameAndAdminContact(adminName, adminContact);
			re=new ResponseEntity<>(a,HttpStatus.OK);
			log.info(re+"");
		 return re;
		}
		
		
		//Deleting a admin by id
		@DeleteMapping("/deleteadmin/{id}")
		@ApiOperation(value = "Delete an admin", notes = "Provide admin id", response = Admin.class)
		public ResponseEntity<Void> deleteAdmin(@PathVariable("id") int id) {
			ResponseEntity<Void>re;
			Optional<Admin> admin=adminRepository.findById(id);
			if(admin.isPresent()) {
			 ad.deleteAdmin(id);
				re=new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				throw new AdminNotExistsException("Admin with id:"+id+" not exists");
			}
			log.info(re+"");
			 return re;
		}



}