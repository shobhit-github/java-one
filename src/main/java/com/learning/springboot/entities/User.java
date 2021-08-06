package com.learning.springboot.entities;

import java.util.Arrays;
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
import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.learning.springboot.utilities.annotations.UniqueEmail;
import com.learning.springboot.utilities.enums.Gender;
import com.learning.springboot.utilities.enums.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "User")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(hidden = true)
	private Long id;

	@Schema(example = "Shobhit", defaultValue = "Shobhit", required = true)
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Please enter first name")
	private String firstName;

	@Schema(example = "Sharma", defaultValue = "Sharma", required = true)
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Please enter last name")
	private String lastName;

	@Schema(example = "sharma-example@yopmail.com", defaultValue = "sharma-example@yopmail.com", required = true)
	@Column(nullable = false, length = 70, unique = true)
	@Email(message = "Please enter valid email id")
	@NotBlank(message = "Please enter email address")
	@UniqueEmail
	private String email;

	@Schema(example = "123456", defaultValue = "123456", required = true)
	@Column(length = 1000, nullable = true)
	@NotBlank(message = "Please enter password")
	private String password;

	@Schema(example = "MALE", defaultValue = "MALE", required = true)
	@Enumerated(value = EnumType.STRING)
	@Column(columnDefinition = "ENUM('MALE', 'FEMALE', 'TRANSGENDER', 'OTHER') default 'MALE'")
	private Gender gender;


	@Temporal(TemporalType.DATE)
	@Schema(required = true, example = "1996-12-23", defaultValue = "1996-12-23")
	@Column()
	private Date birthDate;

	@Schema(example = "DEVOTEE", defaultValue = "DEVOTEE", required = true)
	@Enumerated(value = EnumType.STRING)
	@Column(columnDefinition = "ENUM('DEVOTEE', 'UNION', 'TEMPLE_MANAGEMENT') DEFAULT 'DEVOTEE'")
	private UserType userType;

	@Schema(hidden = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	public User() {
	}

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
