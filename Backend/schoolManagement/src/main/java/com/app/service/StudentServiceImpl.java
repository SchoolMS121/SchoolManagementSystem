package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AttendenceDao;
import com.app.dao.ResultDao;
import com.app.dao.StudentDao;
import com.app.dto.AttendanceRespDto;
import com.app.dto.LoginReqDto;
import com.app.dto.LoginRespDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Attendance;
import com.app.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao stdDao;

	@Autowired
	private ResultDao resDao;

	@Autowired
	private AttendenceDao attDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public LoginRespDto loginStudent(LoginReqDto request) {
		Student std = stdDao.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new RuntimeException("Invalid Email or Password !!!!"));
		return mapper.map(std, LoginRespDto.class);
	}

	@Override
	public ResultRespDto getResult(Student student_id) {

		List<ResultRespDto> result = resDao.getResult(student_id);
		
//Calculate % and Marks for a particular student
		
		ResultRespDto res = result.get(0); //for testing sent only one data // send total marks and %
		System.out.println(result.toString());
		return res;
	}

	@Override
	public AttendanceRespDto getAttendance(Student stu) {
		
		List<AttendanceRespDto> attend =attDao.getAttendance(stu);
		
		AttendanceRespDto att = attend.get(0);
		System.out.println(attend.toString());
		
		return att;
	}
	
	

}






