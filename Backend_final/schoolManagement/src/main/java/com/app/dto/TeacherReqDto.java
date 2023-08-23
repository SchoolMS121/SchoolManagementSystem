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
public class TeacherReqDto {

	private Long teacherId;
	
	private String email;

	private String password;

	private LocalDate dob;

	private String gender;

	private String address;

	private String mobileNo;

	private LocalDate dateOfJoin;

	private String tFirstName;

	private String tLastName;
	
	private int std;
	
	private String division;

}
