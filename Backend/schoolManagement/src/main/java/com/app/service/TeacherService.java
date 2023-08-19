package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.IssueRespDto;
import com.app.dto.ResultReqDto;
import com.app.entities.Result;


public interface TeacherService {

	Result addResult(ResultReqDto request);

	List<IssueRespDto> viewAllIssue();

}
