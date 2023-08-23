package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AttendenceDao;
import com.app.dao.ClassroomDao;
import com.app.dao.ExamDao;
import com.app.dao.IssueDao;
import com.app.dao.ParentDao;
import com.app.dao.ResultDao;
import com.app.dao.StudentDao;
import com.app.dto.AttendanceRespDto;
import com.app.dto.AuthRespDTO;
import com.app.dto.AuthreqDTO;
import com.app.dto.ReqIssueDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Classroom;
import com.app.entities.Exam;
import com.app.entities.Issue;
import com.app.entities.Parent;
import com.app.entities.Result;
import com.app.entities.Student;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {
	@Autowired
	private ParentDao parentDao;
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ClassroomDao classDao;
	@Autowired
	private ResultDao resDao;

	@Autowired
	private AttendenceDao attDao;

	@Autowired
	private StudentDao stdDao;

	@Autowired
	private IssueDao issueDao;
	
	@Autowired
	private ExamDao examDao;

	@Override
	public AuthRespDTO signInParent(AuthreqDTO request) {

		Optional<Parent> parent = parentDao.findByEmailAndPassword(request.getEmail(), request.getPassword());
		return mapper.map(parent, AuthRespDTO.class);
	}

	@Override
	public ResultRespDto getResult(Long parent_id) {


		Student s = stdDao.findByMyParent(new Parent(parent_id, null, null, null, null))
				.orElseThrow(() -> new ResourceNotFoundException("std not found by pId in parent service"));

		
		List<ResultRespDto> list = resDao.getResult(s);
	
		// Calculate % and Marks for a particular student
		double marks = 0l;
		int count = 0;
		for (ResultRespDto r : list) {
			count++;
			marks = marks + r.getMarks();
		}
		double percentage = (marks*100)/(count*100);
		
		ResultRespDto res = new ResultRespDto(marks, percentage, s.getSFirstName(), s.getSLastName(), list.get(0).getStd(), list.get(0).getExam_name());
		
		return res;
		
		

	}

	@Override
	public List<AttendanceRespDto> getAttendance(Long parent_id) {
		
		Student s = stdDao.findByMyParent(new Parent(parent_id, null, null, null, null))
				.orElseThrow(() -> new ResourceNotFoundException("std not found by pId in parent service"));

		List<AttendanceRespDto> attend = attDao.getAttendance(s);

		return attend;

	}

	@Override
	public Optional<Student> getChildInfo(Long parent_id) {

		Student s = stdDao.findByMyParent(new Parent(parent_id, null, null, null, null))
				.orElseThrow(() -> new ResourceNotFoundException("std not found by pId in parent service"));
		return stdDao.findById(s.getStudentId());
	}

	@Override
	public String raiseIssue(Long parent_id, ReqIssueDto issue) {
		Parent par = parentDao.findById(parent_id).orElseThrow();
		Issue issue_to_save = new Issue();

		issue_to_save.setDetails(issue.getDetails());
		issue_to_save.setParent(par);
		issue_to_save.setType(issue.getType());
		issue_to_save.setResolved(false);
		Issue iss = issueDao.save(issue_to_save);
		if (iss != null) {
			return "Issue Raised Successfully";
		}

		return "Please raise your issue again!";
	}

}
