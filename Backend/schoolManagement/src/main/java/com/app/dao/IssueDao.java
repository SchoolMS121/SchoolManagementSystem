package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Issue;

public interface IssueDao extends JpaRepository<Issue, Long> {
   
}
