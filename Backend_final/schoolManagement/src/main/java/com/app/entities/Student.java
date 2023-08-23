package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Student extends User {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "date_of_join")
	private LocalDate dateOfJoin;

	@Column(length = 25, name = "s_first_name")
	private String sFirstName;

	@Column(length = 25, name = "s_last_name")
	private String sLastName;

	// one student table can have multiple parent id since one school can have
	// siblings admitted into one school.
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent myParent;

	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;
}
