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
import javax.persistence.ManyToMany;

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
public class Teacher extends User {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = " teacher_id")
	private Long teacherId;

	@Column(name = "date_of_join")
	private LocalDate dateOfJoin;

	@Column(length = 25, name = "t_first_name")
	private String tFirstName;

	@Column(length = 25, name = "t_last_name")
	private String tLastName;

	// here one classroom can have multiple teachers and one teacher can teach to
	// different classrooms.
	@ManyToMany(mappedBy = "teachers")
	//@JoinColumn(name = "classroom_id")
	List<Classroom> classrooms = new ArrayList<>();

	// helper method to add classroom.
	public void addClassroom(Classroom classroom) {
		if (!classrooms.contains(classroom)) {
			classrooms.add(classroom);
			classroom.addTeacher(this);
		}
	}

	// helper method to remove the classroom.
	public void removeClassroom(Classroom classroom) {
		if (classrooms.contains(classroom)) {
			classrooms.remove(classroom);
			classroom.removeTeacher(this);
		}
	}

}
