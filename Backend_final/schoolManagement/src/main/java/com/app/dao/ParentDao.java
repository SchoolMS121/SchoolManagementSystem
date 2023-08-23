package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Parent;
import com.app.entities.Teacher;

public interface ParentDao extends JpaRepository<Parent, Long> {

	
//	Optional<Parent> findByPFirstName(String pFirstName);
	
	@Query("select p from Parent p where p.pFirstName = ?1 ")
	Optional<Parent> findByPFirstName(String pFirstName);
	
	Optional<Parent> findByEmailAndPassword(String email, String password);

	
	
}
