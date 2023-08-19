package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.ResultRespDto;
import com.app.entities.Parent;
import com.app.entities.Result;
import com.app.entities.Student;

public interface ResultDao extends JpaRepository<Result, Long>{
//to change exam name field in Exam and add here
	@Query("select new com.app.dto.ResultRespDto (r.marks , s.s_first_name, s.s_last_name  , sb.subject_name , sb.std , e.exam_name ,p.p_first_name) "
			+ "from Result r , Student s , Subject sb , Exam e , Parent p "
			+ "where r.student = s.student_id and r.subject = sb.subject_id and r.exam = e.exam_id and r.parent = p.parent_id "
			+ "and r.parent = ?1 ")
	List<ResultRespDto> getResult(Parent parent_id);
}
	


