package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AdminTimeTableDao;
import com.app.dao.AttendenceDao;
import com.app.dao.ClassroomDao;
import com.app.dao.ExamDao;
import com.app.dao.IssueDao;
import com.app.dao.ParentDao;
import com.app.dao.ResultDao;
import com.app.dao.StudentDao;
import com.app.dao.SubjectDao;
import com.app.dao.TeacherDao;
import com.app.dto.ApiResponse;
import com.app.dto.AttendanceReqDto;
import com.app.dto.IssueReqDto;
import com.app.dto.IssueRespDto;
import com.app.dto.ResultReqDto;
import com.app.dto.TimeTableDto;
import com.app.entities.Attendance;
import com.app.entities.Classroom;
import com.app.entities.Exam;
import com.app.entities.Issue;
import com.app.entities.Parent;
import com.app.entities.Result;
import com.app.entities.Student;
import com.app.entities.Subject;
import com.app.entities.Teacher;
import com.app.entities.Timetable;

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
	@Autowired
	private TeacherDao teaDao;//
	@Autowired
	private AttendenceDao attDao;//
	@Autowired
	private AdminTimeTableDao ttableDao;
	@Autowired
	private ClassroomDao classDao;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public Result addResult(ResultReqDto request) {
		
		System.out.println(request.getExam_name());
		
		Exam e = examDao.getExamDetails(request.getExam_name())
				.orElseThrow(() -> new ResourceNotFoundException("Exam details not found in addResult of teaservice"));

		Subject su = subjDao.getSubjectDetails(request.getSubject_name())
				.orElseThrow(() -> new ResourceNotFoundException("Subject details not found in addResult of teaservice"));
		System.out.println(su);
		
		Student st = stuDao.getStudentDetails(request.getS_first_name())
				.orElseThrow(() -> new ResourceNotFoundException("Student details not found in addResult of teaservice"));
		System.out.println(st);
		
		Parent p = parDao.getParentDetails(request.getP_first_name())
				.orElseThrow(() -> new ResourceNotFoundException("Parent details not found in addResult of teaservice"));
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

	@Override
	public ApiResponse handleIssue(Long issue_id ,IssueReqDto req) {
		Issue issue = issueDao.findById(issue_id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Issue ID !!!!! in handle issue of "));
		
		Parent p = parDao.getParentDetails(req.getP_first_name()).orElseThrow(()-> new ResourceNotFoundException("Parent  not found in handle issue of teaservice"));
		
		Issue i = new Issue(issue_id, p, req.getType(), req.getDetails(), true);
		
		
		issue.getParent().getIssue().size();
		
		issueDao.save(i);
		return new ApiResponse("Issue resolved");
		
		
	}

	
	
	
	@Override
	public Attendance addAttendance(AttendanceReqDto request) {
		Teacher teach =teaDao.findById(request.getTeacher_id()).orElseThrow(()-> new ResourceNotFoundException("teacher not found in add Atte of teaService"));
		Student std = stuDao.getStudentDetails(request.getS_first_name()).orElseThrow(()->new ResourceNotFoundException("Student not found in add Atte of teaService"));
		Attendance attnd =new Attendance();
		attnd.setStudent(std);
		attnd.setTeacher(teach);
		attnd.setStatus(request.isStatus());
		attnd.setDate(request.getDate());
		attnd.setUser_id(0l);
				
		return attDao.save(attnd);
	
	
	}
	
	
	
	@Override
	public Timetable addTimeTable(Long classroom_id, TimeTableDto ttable) {
		Classroom class_id=classDao.findById(classroom_id).orElseThrow();
		class_id.getStudent().size();
		Timetable tt=new Timetable();
		tt.setClassroom(class_id);
		tt.setDay(ttable.getDay());
		tt.setSubject(ttable.getSubject());
		tt.setTime(ttable.getTime());
		tt.setTt_id(ttable.getTt_id());
		
		
		
		return ttableDao.save(tt);
	}
	
	
	
	
	
	
	
	
	
}
