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
	private String sFirstName;
	private String sLastName;

	private int std;
	private String examName;

	public ResultRespDto(double marks, String sFirstName, String sLastName, int std, String examName) {
		
		this.marks = marks;
		this.sFirstName = sFirstName;
		this.sLastName = sLastName;
		this.std = std;
		this.examName = examName;
	}
}
