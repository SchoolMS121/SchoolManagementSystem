package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Teacher;

public interface AdminTeacherDao extends JpaRepository<Teacher, Long> {

}
