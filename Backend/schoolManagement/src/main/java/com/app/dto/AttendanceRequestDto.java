package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AttendanceRequestDto {

private Long user_id;
	
	private LocalDate date;
	
	private boolean status;
}
