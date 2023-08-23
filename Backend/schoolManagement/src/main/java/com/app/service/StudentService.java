package com.app.service;

import com.app.dto.AttendanceRespDto;
import com.app.dto.LoginReqDto;
import com.app.dto.LoginRespDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Student;

public interface StudentService {

	LoginRespDto loginStudent(LoginReqDto request);

	ResultRespDto getResult(Long student_id);

	AttendanceRespDto getAttendance(Long stu);

	
}
