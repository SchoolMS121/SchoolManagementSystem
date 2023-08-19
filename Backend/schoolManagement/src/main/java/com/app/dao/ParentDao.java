package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Parent;
import com.app.entities.Teacher;

public interface ParentDao extends JpaRepository<Parent, Long> {

	@Query("select p from Parent p where p.p_first_name = ?1")
	Optional<Parent> getParentDetails(String p_first_name);
}
