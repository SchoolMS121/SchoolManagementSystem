
  package com.app.dao;
  
  import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Student;

  
  public interface AdminDao extends JpaRepository<Student, Long> {
  
  }
 
