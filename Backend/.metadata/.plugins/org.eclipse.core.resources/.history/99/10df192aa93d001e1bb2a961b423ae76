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
@ToString
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issue_id;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;

	@Column(length = 30)
	private String type;

	private String Details;

	private boolean is_resolved;

}
