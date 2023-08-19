package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@ToString
public class Timetable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tt_id;

	@OneToOne
	@JoinColumn(name = "classroom_id", referencedColumnName = "classroom_id")
	private Classroom classroom;

	private String day;
 
	private LocalTime time;

	private String subject;

}
