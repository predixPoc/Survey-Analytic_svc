package com.ge.survey.analytic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the USER_DETAIL database table.
 * 
 */

@Entity
@Table(name="USER_DETAILS")
@NamedQuery(name="UserDetails.findAll", query="SELECT u FROM UserDetails u")
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_DETAILS_USERID_GENERATOR", sequenceName="USER_SEQ1")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_DETAILS_USERID_GENERATOR")
	@Column(name="USER_ID")
	private long userId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="ADDRESS")
	private String Address;

	@Column(name="PHONE_NUMBER")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="COMPANY_NAME")
	private String companyName;

	public UserDetails() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


}