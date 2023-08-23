package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
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
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email and Psssword!!! -> in Student login"));
		return mapper.map(std, LoginRespDto.class);
	}

	@Override
	public ResultRespDto getResult(Long student_id) {

		Student s = new Student();
		s.setStudentId(student_id);
		List<ResultRespDto> result = resDao.getResult(s);
		double x = 0l;
//Calculate % and Marks for a particular student
		for (ResultRespDto r : result) {
			x=x+r.getMarks();
		}
		
		ResultRespDto res = result.get(0); //for testing sent only one data // send total marks and %
		res.setMarks(x);
		System.out.println(result.toString());
		return res;
	}

	@Override
	public AttendanceRespDto getAttendance(Long stu) {
		
		Student s= new Student();
		s.setStudentId(stu);
		
		List<AttendanceRespDto> attend =attDao.getAttendance(s);
		
		AttendanceRespDto att = attend.get(0);
		System.out.println(attend.toString());
		
		return att;
	}
	
	

}






