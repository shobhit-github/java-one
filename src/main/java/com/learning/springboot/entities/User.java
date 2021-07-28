package com.learning.springboot.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.learning.springboot.utilities.enums.Gender;
import com.learning.springboot.utilities.enums.UserType;

@Entity(name = "User")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50, name = "firstName")
	private String firstName;
	
	@Column(nullable = false, length = 50, name = "lastName")
	private String lastName;
	
	@Column(nullable = false, length = 70, unique = true, name = "email")
	private String email;
	
	@Column(length = 1000, nullable = true)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birthDate", nullable = true)
	private Date birthDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "userType")
	private UserType userType = UserType.DEVOTEE;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = true)
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User(Long id, String firstName, String lastName, String email, String password, Gender gender,
			Date birthDate, UserType userType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.userType = userType;
	}



	
}
