package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.ResultRespDto;
import com.app.entities.Result;
import com.app.entities.Student;

public interface ResultDao extends JpaRepository<Result, Long>{
//to change exam name field in Exam and add here
	@Query("select new com.app.dto.ResultRespDto (r.marks , s.s_first_name, s.s_last_name  , sb.subject_name , sb.std , e.exam_name ,p.p_first_name) "
			+ "from Result r , Student s , Subject sb , Exam e , Parent p "
			+ "where r.student = s.student_id and r.subject = sb.subject_id and r.exam = e.exam_id and r.parent = p.parent_id "
			+ "and r.student = ?1 ")
	List<ResultRespDto> getResult(Student student_id);
}
//@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto
//(d.name, e.name, e.email, e.address) "
//		+ "FROM Department d, Employee e")
//List<DeptEmpDto> fetchEmpDeptDataCrossJoin();

//@Query("select r from Result r where r.student=?1")
//Optional<Result> getResult(Students student_id);

//@Query("select new com.app.dto.ResultRespDto"
//		+ "(r.marks , s.first_name , sb.name , sb.grade ) "
//		+ "from Result r , Student s , Subject sb "
//      + "where r.student_id = s.student_id and r.subject_id = sb.subject_id"
//		+ "where r.student_id = ?1")

//@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.JoinDto
//(s.id, f.name, c.name, s.amount) "
//		+ "FROM Sale s, Food f, Company c WHERE s.food.id = f.id AND f.company.id = c.id")
//List<JoinDto> fetchDataCrossJoin();





//@Query(nativeQuery = true , value = "select r.marks , s.first_name , sb.name , sb.grade from "
//		+ "result r , students s , subject sb"
//		+ " where r.student_id = s.student_id and r.subject_id = sb.subject_id"
//		+ " and r.student_id = ?1")

//@Query(nativeQuery = true , value = "select r.marks , s.first_name , sb.name , sb.grade from "
//		+ "result r , students s , subject sb"
//		+ " where r.student_id = s.student_id and r.subject_id = sb.subject_id"
//		+ " and r.student_id = ?1")

