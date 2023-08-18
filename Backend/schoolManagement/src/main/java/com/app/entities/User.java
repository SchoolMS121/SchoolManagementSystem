package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class User {

	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "password", nullable = false, length = 30)
	private String password;

	private LocalDate dob;

	@Column(length = 10)
	private String gender;

	@Column(length = 250)
	private String address;

	@Column(length = 13)
	private String mobile_no;

}
