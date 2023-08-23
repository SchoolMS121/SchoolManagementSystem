package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Parent;
import com.app.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

	Optional<Student> findByEmailAndPassword(String email,String password);
		
	@Query("select s from Student s where s.sFirstName = ?1 ")
	Optional<Student> findBySFirstName(String sFirstName);
	
	Optional<Student> findByMyParent(Parent p);
}
