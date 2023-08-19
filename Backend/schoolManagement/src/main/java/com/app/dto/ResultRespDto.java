package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultRespDto {

//	private Long exam_id;
//	private Long parent_id;
//	private Long student_id;
//	private double marks;
//	private Long subject_id;
	private double marks;
	private String s_first_name;
	private String s_last_name;
	private String subject_name;
	private int std ;
	private String exam_name ;
	private String p_first_name;
}
