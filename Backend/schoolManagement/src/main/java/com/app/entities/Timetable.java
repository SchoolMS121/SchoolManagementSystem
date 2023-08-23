package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Timetable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tt_id")
	private Long ttId;

	// here we made bidirectional so that timetable can have a identity to identify
	// the class.
	@OneToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	private String day;

	private LocalTime time;

	// one timetable can have many different subjects so the relation is @Manytoone.
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

}
