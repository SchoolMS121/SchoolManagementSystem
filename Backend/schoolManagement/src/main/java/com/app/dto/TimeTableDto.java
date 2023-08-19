package com.app.dto;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class TimeTableDto {
	private Long tt_id;
	

	private String day;
	
	 @Schema(example = "02:00")
	private LocalTime time;

	private String subject;
}
