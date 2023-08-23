package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.AttendanceRespDto;
import com.app.entities.Attendance;
import com.app.entities.Parent;
import com.app.entities.Student;

public interface AttendenceDao extends JpaRepository<Attendance, Long> {


	@Query(" select new com.app.dto.AttendanceRespDto ( s.sFirstName, s.sLastName  , a.status , a.date) "
			+ "from Attendance a , Student s where s.studentId = a.student and a.student = ?1 ")
	List<AttendanceRespDto> getAttendance(Student studentId);

}
