package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ExamDao;
import com.app.dao.IssueDao;
import com.app.dao.ParentDao;
import com.app.dao.ResultDao;
import com.app.dao.StudentDao;
import com.app.dao.SubjectDao;
import com.app.dto.IssueRespDto;
import com.app.dto.ResultReqDto;
import com.app.entities.Exam;
import com.app.entities.Parent;
import com.app.entities.Result;
import com.app.entities.Student;
import com.app.entities.Subject;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private ResultDao resDao;
	@Autowired
	private ExamDao examDao;//
	@Autowired
	private ParentDao parDao;//
	@Autowired
	private StudentDao stuDao;//
	@Autowired
	private SubjectDao subjDao;//
	@Autowired
	private IssueDao issueDao;//

	@Override
	public Result addResult(ResultReqDto request) {
		
		System.out.println(request.getExam_name());
		
		Exam e = examDao.getExamDetails(request.getExam_name())
				.orElseThrow(() -> new RuntimeException("Exam details not found"));

		Subject su = subjDao.getSubjectDetails(request.getSubject_name())
				.orElseThrow(() -> new RuntimeException("Subject details not found"));
		System.out.println(su);
		
		Student st = stuDao.getStudentDetails(request.getS_first_name())
				.orElseThrow(() -> new RuntimeException("Student details not found"));
		System.out.println(st);
		
		Parent p = parDao.getParentDetails(request.getP_first_name())
				.orElseThrow(() -> new RuntimeException("Parent details not found"));
		System.out.println(p);
		
		Result r = new Result();
		r.setExam(e);
		r.setMarks(request.getMarks());
		r.setParent(p);
		r.setStudent(st);
		r.setSubject(su);
		System.out.println(r);
		
		return resDao.save(r);
	}

	@Override
	public List<IssueRespDto> viewAllIssue() {
		
		List<IssueRespDto> list = issueDao.getAllIssues();
		
		System.out.println(list.toString());
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
