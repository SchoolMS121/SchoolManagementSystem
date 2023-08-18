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
@ToString
public class Parent extends User {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parent_id;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Issue> issue = new ArrayList<>();

	@Column(length = 25)
	private String p_first_name;

	@Column(length = 25)
	private String p_last_name;

}
