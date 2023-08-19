package com.app.service;

import java.util.Optional;

import com.app.dto.AttendanceRespDto;
import com.app.dto.AuthRespDTO;
import com.app.dto.AuthreqDTO;
import com.app.dto.ReqIssueDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Parent;
import com.app.entities.Student;

public interface ParentService {

	AuthRespDTO signInParent(AuthreqDTO request);

	AttendanceRespDto getAttendance(Parent parent_id);

	ResultRespDto getResult(Parent parent_id);

	Optional<Student> getChildInfo(Long student_id);



	String raiseIssue(Long parent_id, ReqIssueDto issue);

}