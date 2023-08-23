package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.AttendanceReqDto;
import com.app.dto.IssueReqDto;
import com.app.dto.IssueRespDto;
import com.app.dto.ResultReqDto;
import com.app.dto.TimeTableDto;
import com.app.entities.Attendance;
import com.app.entities.Result;
import com.app.entities.Timetable;


public interface TeacherService {

	Result addResult(ResultReqDto request);

	List<IssueRespDto> viewAllIssue();

	ApiResponse handleIssue(Long issue_id, IssueReqDto request);

	Attendance addAttendance(AttendanceReqDto request);

	String addTimeTable( TimeTableDto ttable);

}
