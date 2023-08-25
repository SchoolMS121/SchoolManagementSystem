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

		Student s = stdDao.findById(student_id).orElseThrow();
//		s.setStudentId(student_id);
		List<ResultRespDto> result = resDao.getResult(s);
		double marks = 0l;
		int count = 0;
		for (ResultRespDto r : result) {
			count++;
			marks = marks + r.getMarks();
		}
		double percentage = (marks*100)/(count*100);
		
		ResultRespDto res = new ResultRespDto(marks, percentage, s.getSFirstName(), s.getSLastName(), result.get(0).getStd(), result.get(0).getExamName());
		
		return res;
		
	}

	@Override
	public List<AttendanceRespDto> getAttendance(Long stu) {
		
		Student s= new Student();
		s.setStudentId(stu);
		
		List<AttendanceRespDto> attend =attDao.getAttendance(s);
		
//		AttendanceRespDto att = attend.get(0);
//		System.out.println(attend.toString());
		
		return attend;
	}
	
	

}






