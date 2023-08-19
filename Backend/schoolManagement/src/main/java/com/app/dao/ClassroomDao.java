package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Classroom;

public interface ClassroomDao extends JpaRepository<Classroom, Long>{

}
