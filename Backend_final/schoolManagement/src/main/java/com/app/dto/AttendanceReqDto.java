package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceReqDto {

	private Long teacher_id;

	private String s_first_name;

	private LocalDate date;

	private boolean status;
}
