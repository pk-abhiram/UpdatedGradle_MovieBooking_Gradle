package com.sprint1.movie.booking.ticket1.booking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "admin")
@ApiModel("List of Adim")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //Fields
	private int adminId;
	@Column(nullable = false)
	private String adminName;
	@Column(nullable = false)
	private String adminContact;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity = User.class,orphanRemoval = true)
	User user;

	//Constructors
	public Admin() {
		super();
	}

	
	public Admin(int adminId, String adminName, String adminContact, String email, String password, User user) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.email = email;
		this.password = password;
		this.user = user;
	}


	public Admin(String adminName, String adminContact, String email, String password, User user) {
		super();
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.email = email;
		this.password = password;
		this.user = user;
	}


	//Getters and setters
	


	
	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminContact() {
		return adminContact;
	}


	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminContact == null) ? 0 : adminContact.hashCode());
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminContact == null) {
			if (other.adminContact != null)
				return false;
		} else if (!adminContact.equals(other.adminContact))
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact + ", email="
				+ email + ", password=" + password + ", user=" + user + "]";
	}
	
	
	}