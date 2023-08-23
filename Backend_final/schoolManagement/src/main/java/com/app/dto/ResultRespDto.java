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

	private double percentage;
	private String s_first_name;
	private String s_last_name;

	private int std;
	private String exam_name;

	public ResultRespDto(double marks, String s_first_name, String s_last_name, int std, String exam_name) {
		
		this.marks = marks;
		this.s_first_name = s_first_name;
		this.s_last_name = s_last_name;
		this.std = std;
		this.exam_name = exam_name;
	}
}
