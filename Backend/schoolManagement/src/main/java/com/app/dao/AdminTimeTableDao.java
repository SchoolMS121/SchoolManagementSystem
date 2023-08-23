package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Timetable;

public interface AdminTimeTableDao extends JpaRepository<Timetable, Long> {

}
