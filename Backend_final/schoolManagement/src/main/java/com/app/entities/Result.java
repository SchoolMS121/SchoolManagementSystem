package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "result_id")
	private Long resultId;

	private Double marks;

	// one result table can contain multiple results of a single student eg unit
	// test result ,semester result so student_id would be repeated hence.
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	// the reason here is same as above.
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;

	// the reason here is same as above.
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

}
