package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Student;
import com.app.entities.Subject;

public interface StudentDao extends JpaRepository<Student, Long> {

	Optional<Student> findByEmailAndPassword(String email,String password);
	
	@Query("select s from Student s where s.s_first_name = ?1")
	Optional<Student> getStudentDetails(String s_first_name);
}
