package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classroom_id")
	private Long classroomId;

	private int std;

	private String division;

	// Each classroom can have more than one teacher and vice a versa so
	// relationship is @manytomany.
	//@ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "classrooms")
	// @JoinTable(name = "classroom_teacher", joinColumns = @JoinColumn(name =
	// "classroom_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="classroom_teacher",
	joinColumns = @JoinColumn(name="classroom_id"),
	inverseJoinColumns = @JoinColumn(name="teacher_id"))
	private List<Teacher> teachers = new ArrayList<>();

	// one classroom can have one timetable and same vice a versa
//	@OneToOne(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Timetable timetable;

	// one classroom can have multiple student so the relationship is @onetomany and
	// here the FK (classroom_id) will be added in student table.
//	@OneToMany
//	@JoinColumn(name = "classroom_id")
//	private List<Student> students = new ArrayList<Student>();
	
	@OneToMany
	@JoinColumn(name = "classroom_id")
	private List<Subject> subjects = new ArrayList<Subject>();

	// will help to add teacher in teacher table
	public void addTeacher(Teacher teacher) {
		if (!teachers.contains(teacher)) {
			teachers.add(teacher);
			teacher.addClassroom(this);
		}
	}

	// will help to remove teacher from teacher table
	public void removeTeacher(Teacher teacher) {
		if (teachers.contains(teacher)) {
			teachers.remove(teacher);
			teacher.removeClassroom(this);
		}
	}

}
