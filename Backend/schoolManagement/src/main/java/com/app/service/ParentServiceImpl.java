package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AttendenceDao;
import com.app.dao.IssueDao;
import com.app.dao.ParentDao;
import com.app.dao.ResultDao;
import com.app.dao.StudentDao;
import com.app.dto.AttendanceRespDto;
import com.app.dto.AuthRespDTO;
import com.app.dto.AuthreqDTO;
import com.app.dto.ReqIssueDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Issue;
import com.app.entities.Parent;
import com.app.entities.Student;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {
	@Autowired
	private ParentDao parentDao;
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ResultDao resDao;

	@Autowired
	private AttendenceDao attDao;
	
	@Autowired
	private StudentDao stdDao;
	
	@Autowired
	private IssueDao issueDao;

	@Override
	public AuthRespDTO signInParent(AuthreqDTO request) {

		Optional<Parent> parent = parentDao.findByEmailAndPassword(request.getEmail(), request.getPassword());
		return mapper.map(parent, AuthRespDTO.class);
	}

	@Override
	public ResultRespDto getResult(Parent parent_id) {
		List<ResultRespDto> result = resDao.getResult(parent_id);

		// Calculate % and Marks for a particular student

		ResultRespDto res = result.get(0); // for testing sent only one data // send total marks and %
		System.out.println(result.toString());
		return res;

	}

	@Override
	public AttendanceRespDto getAttendance(Parent parent_id) {
		List<AttendanceRespDto> attend = attDao.getAttendance(parent_id);

		AttendanceRespDto att = attend.get(0);
		System.out.println(attend.toString());

		return att;

	}


	@Override
	public Optional<Student> getChildInfo(Long student_id) {
		
		return stdDao.findById(student_id);
	}

	@Override
	public String raiseIssue(Long parent_id,ReqIssueDto issue) {
	Parent par=parentDao.findById(parent_id).orElseThrow();
		Issue issue_to_save=new Issue();
		
		issue_to_save.setDetails(issue.getDetails());
		issue_to_save.setParent(par);
		issue_to_save.setType(issue.getType());
		issue_to_save.set_resolved(false);
		Issue iss=issueDao.save(issue_to_save);
		if(iss!=null)
		{
			return "Issue Raised Successfully";
		}
		
		return "Please raise your issue again!";
	}

	

	

}
