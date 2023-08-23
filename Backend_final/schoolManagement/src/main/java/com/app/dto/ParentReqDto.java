package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParentReqDto {

	private Long parentId;
	
	private String email;

	private String password;

	private LocalDate dob;

	private String gender;

	private String address;

	private String mobileNo;

	private String pFirstName;

	private String pLastName;

}
