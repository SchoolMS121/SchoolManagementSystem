
  package com.app.dto;
  
  import java.sql.Date;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
  
@Getter
@Setter
@ToString
  public class SignUpParentDto { 
private Long parentId;

private String pFirstName;

private String pLastName;
	  
 private LocalDate DOB;
  
  private String gender;
  
  private String address;
  
  private String mobileNo;
  
  private String email;
  
  private String password;
  
  

  
  }
 
