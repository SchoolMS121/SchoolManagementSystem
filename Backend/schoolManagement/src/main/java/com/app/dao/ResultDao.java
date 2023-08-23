package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.ResultRespDto;
import com.app.entities.Parent;
import com.app.entities.Result;
import com.app.entities.Student;

public interface ResultDao extends JpaRepository<Result, Long> {

	List<Result> findByStudent(Student s);

	@Query("select new com.app.dto.ResultRespDto (r.marks , s.sFirstName, s.sLastName  , c.std  , e.examName ) "
			+ "from Result r , Student s , Classroom c, Exam e "
			+ "where r.student = s.studentId and s.classroom = c.classroomId and r.exam = e.examId  "
			+ "and r.student = ?1 ")
	List<ResultRespDto> getResult(Student student);

}