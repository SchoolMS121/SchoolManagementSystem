package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Teacher extends User {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacher_id;

	private LocalDate date_of_join;

	@Column(length = 25)
	private String t_first_name;

	@Column(length = 25)
	private String t_last_name;

}
