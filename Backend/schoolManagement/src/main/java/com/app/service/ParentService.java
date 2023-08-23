package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.AttendanceRespDto;
import com.app.dto.AuthRespDTO;
import com.app.dto.AuthreqDTO;
import com.app.dto.ReqIssueDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Student;

public interface ParentService {

	AuthRespDTO signInParent(AuthreqDTO request);

	List<AttendanceRespDto> getAttendance(Long parent_id);

	ResultRespDto getResult(Long parent_id);

	Optional<Student> getChildInfo(Long parent_id);



	String raiseIssue(Long parent_id, ReqIssueDto issue);

}
