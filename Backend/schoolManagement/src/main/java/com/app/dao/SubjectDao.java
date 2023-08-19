package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Subject;
import com.app.entities.Teacher;

public interface SubjectDao extends JpaRepository<Subject, Long> {

	@Query("select s from Subject s where s.subject_name = ?1")
	Optional<Subject> getSubjectDetails(String subject_name);
}
