package com.app.dao; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.dto.IssueRespDto;
import com.app.entities.Issue;

public interface IssueDao extends JpaRepository<Issue, Long> {

	@Query("select new com.app.dto.IssueRespDto(p.p_first_name , i.type , i.details , i.is_resolved)  "
			+ "from Issue i , Parent p where i.parent = p.parent_id")
	List<IssueRespDto> getAllIssues();
}
