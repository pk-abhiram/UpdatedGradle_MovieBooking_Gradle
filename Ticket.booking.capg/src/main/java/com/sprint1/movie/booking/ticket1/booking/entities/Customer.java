package com.sprint1.movie.booking.ticket1.booking.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.swagger.annotations.ApiModel;
@Entity
@ApiModel("Customers")
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(nullable = false)
	private String customerName;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String mobileNo;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;

	@OneToOne(cascade=CascadeType.ALL,targetEntity = User.class,orphanRemoval = true)
	User user;

	@OneToMany(cascade=CascadeType.ALL,targetEntity = TicketBooking.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	List<TicketBooking> ticketBooking;

	public Customer() {}

	public Customer(String customerName, String address, String mobileNo, String email, String password) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
	}

	public Customer(int customerId,String customerName, String address, String mobileNo, String email, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TicketBooking> getTicketBooking() {
		return this.ticketBooking;
	}

	public void setTicketBooking(List<TicketBooking> ticketBooking) {
		this.ticketBooking = ticketBooking;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticketBooking == null) ? 0 : ticketBooking.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Customer other = (Customer) obj;
		if (ticketBooking == null) {
			if (other.ticketBooking != null)
				return false;
		} else if (!ticketBooking.equals(other.ticketBooking))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", password=" + password + ", user=" + user
				+ ", TicketBooking=" + ticketBooking + "]";
	}



}

