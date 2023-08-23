package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Parent extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parent_id")
	private Long parentId;

	// one parent can raise multiple issues.
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Issue> issue = new ArrayList<>();

	@Column(length = 25, name = "p_first_name")
	private String pFirstName;

	@Column(length = 25, name = "p_last_name")
	private String pLastName;

	// one parent can have multiple children admitted into one school.
	@OneToMany(mappedBy = "myParent")
	private List<Student> students = new ArrayList<Student>();

}
