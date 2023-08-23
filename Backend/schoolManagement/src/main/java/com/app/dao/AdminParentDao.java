package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Parent;

public interface AdminParentDao extends JpaRepository<Parent, Long>{

}
