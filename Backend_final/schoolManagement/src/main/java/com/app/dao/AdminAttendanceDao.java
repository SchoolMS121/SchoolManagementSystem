package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Attendance;

public interface AdminAttendanceDao extends JpaRepository<Attendance, Long>{

}
