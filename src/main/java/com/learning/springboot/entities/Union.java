package com.learning.springboot.entities;

import com.learning.springboot.utilities.annotations.UniqueDomain;
import com.learning.springboot.utilities.annotations.UniqueEmail;

import com.learning.springboot.utilities.enums.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Entity(name = "Unions")
public class Union {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(hidden = true)
	private Long id;

	@Schema(example = "Balaji Sang Reg.", defaultValue = "Balaji Sang Reg", required = true)
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Please enter union name")
	private String unionName;

	@Schema(example = "balajisang@yopmail.com", defaultValue = "balajisang@yopmail.com", required = true)
	@Column(length = 70, unique = true)
	@Email(message = "Please enter valid email id")
	@UniqueEmail(checkFor = UserType.UNION)
	private String email;

	@Schema(example = "www.example.com", defaultValue = "www.example.com")
	@Column(unique = true)
	@UniqueDomain(checkFor = UserType.UNION)
	private String website;

	@Schema(example = "Sample Description", defaultValue = "Sample Description")
	@Column(columnDefinition = "TEXT")
	@NotBlank(message = "Please enter description of the temple")
	private String description;

	@Temporal(TemporalType.DATE)
	@Schema(required = true, example = "1996-12-23", defaultValue = "1996-12-23")
	@NotNull(message = "Please specify establish date")
	@Column()
	private Date establishDate;

	@Schema(hidden = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "union")
	private Collection<User> users;

	public Union(String unionName, String email, String website, String description, Date establishDate) {
		this.unionName = unionName;
		this.email = email;
		this.website = website;
		this.description = description;
		this.establishDate = establishDate;
	}

	public Union() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
