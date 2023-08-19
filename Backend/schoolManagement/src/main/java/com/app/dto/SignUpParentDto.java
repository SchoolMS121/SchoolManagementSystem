
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
private Long parent_id;

private String p_first_name;

private String p_last_name;
	  
 private LocalDate DOB;
  
  private String gender;
  
  private String address;
  
  private String mobile_no;
  
  private String email;
  
  private String password;
  
  

  
  }
 
