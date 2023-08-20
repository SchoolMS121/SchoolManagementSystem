package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Classroom;

public interface ClassroomDao extends JpaRepository<Classroom, Long>{
	
	/*
	 * @Query(nativeQuery = true)
	 * 
	 * Classroom addClassroom(Classroom classroom);
	 */

}
