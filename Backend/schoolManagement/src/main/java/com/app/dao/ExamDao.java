package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Exam;
import com.app.entities.Teacher;

public interface ExamDao extends JpaRepository<Exam, Long> {

	Optional<Exam> findByExamName(String examName);


}
