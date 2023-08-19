package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.AuthreqDTO;
import com.app.entities.Parent;

public interface ParentDao extends JpaRepository<Parent, Long> {

	

	

	Optional<Parent> findByEmailAndPassword(String email, String password);

}
