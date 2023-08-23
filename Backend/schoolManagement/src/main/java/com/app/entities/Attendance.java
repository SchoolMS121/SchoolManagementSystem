package com.app.entities;

import java.time.LocalDate;

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

public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "user_id")
	private Long userId; // primary key

	private LocalDate date;

	private boolean status;// present or absent

	// the relationship explains that one attendance table can have more than one
	// attendances of single student.
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	// to know which teacher has recorded the attendance of that particular student
	// and not to maintain teacher attendance.
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

}
