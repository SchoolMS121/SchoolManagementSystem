
package com.app.service;

import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AdminAttendanceDao;
import com.app.dao.AdminDao;
import com.app.dao.AdminTeacherDao;
import com.app.dao.AdminTimeTableDao;
import com.app.dao.ClassroomDao;
import com.app.dao.ParentDao;
import com.app.dao.SubjectDao;
import com.app.dto.ClassroomRequestDto;
import com.app.dto.ParentReqDto;
import com.app.dto.ResultReqDto;
import com.app.dto.SignUpParentDto;
import com.app.dto.StudentReqDto;
import com.app.dto.TeacherReqDto;
import com.app.dto.TimeTableDto;
import com.app.entities.Classroom;
import com.app.entities.Exam;
import com.app.entities.Parent;
import com.app.entities.Result;
import com.app.entities.Student;
import com.app.entities.Subject;
//import com.app.entities.Person;
import com.app.entities.Teacher;
import com.app.entities.Timetable;

//import com.app.entities.User;

@Service

@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminTeacherDao teacherDao;
	@Autowired
	private ParentDao parentDao;
	@Autowired
	private AdminTimeTableDao ttableDao;
	@Autowired
	private ClassroomDao classDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private AdminAttendanceDao attendanceDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public String addStudentDetails(StudentReqDto stud) {

		Parent parent = parentDao.findByPFirstName(stud.getMyParent()).orElseThrow(() -> new ResourceNotFoundException("parent not found in admin"));
		parent.getIssue().size();
		parent.getStudents().size();
		Classroom c = classDao.findByStdAndDivision(stud.getStd(),stud.getDivision()).orElseThrow(() -> new ResourceNotFoundException("class not found admin"));
		
		Student s = mapper.map(stud, Student.class);
		s.setClassroom(c);
		s.setMyParent(parent);
		adminDao.save(s);
		return "Student added Succefully";
	}

	@Override
	public String updateStudentsDetail(StudentReqDto stud) {
		Student foundStud = adminDao.findById(stud.getStudentId()).orElseThrow();
		Classroom classData = classDao.findByStdAndDivision(stud.getStd(),stud.getDivision()).orElseThrow();
		classData.getTeachers().size();
		classData.getSubjects().size();
		Parent foundParent = parentDao.findByPFirstName(stud.getMyParent()).orElseThrow();
		foundParent.getIssue().size();
		Student map = mapper.map(stud, Student.class);
		map.setClassroom(classData);
		map.setMyParent(foundParent);
		
		adminDao.save(map);
		
		
		return "Updated successfully";
	}

	@Override
	public String deleteStudentDetails(Long studentId) {
		Student foundStud = adminDao.findById(studentId).orElseThrow();
		adminDao.deleteById(studentId);
		return "Student Details Deleted Successfully";
	}

	@Override
	public String addTeacherDetails(TeacherReqDto teacher) {
		//TODO :to be seen later
		Classroom c = classDao.findByStdAndDivision(teacher.getStd(), teacher.getDivision()).orElseThrow();
		c.addTeacher(mapper.map(teacher, Teacher.class));
		classDao.save(c);
		return "Teacher added";

	}

	@Override
	public Teacher updateTeacherDetails(TeacherReqDto teacher) {
		Teacher foundTeacher = teacherDao.findById(teacher.getTeacherId()).orElseThrow();
		return teacherDao.save(mapper.map(teacher, Teacher.class));
	}

	@Override
	public String deleteTeacherDetails(int std,String division, Long teacherId) {
		Teacher foundTeacher = teacherDao.findById(teacherId).orElseThrow();
		Classroom c = classDao.findByStdAndDivision(std,division).orElseThrow();
		c.getTeachers().size();
		c.getSubjects().size();
		c.removeTeacher(foundTeacher);
		teacherDao.delete(foundTeacher);
		return "Teacher Details Deleted Successfully";
	}

	@Override
	public Parent addParentDetails(ParentReqDto parent) {
//		System.out.println(request);
//		Parent parent = mapper.map(request, Parent.class);
		System.out.println(parent);
		
		return parentDao.save(mapper.map(parent, Parent.class));
	}

	@Override
	public Parent updateParentDetails(SignUpParentDto request) {

		Parent foundParent = parentDao.findById(request.getParentId()).orElseThrow();
		foundParent.getStudents().size();
		foundParent.getIssue().size();
		Parent parent = mapper.map(request, Parent.class);
		return parentDao.save(parent);
	}

	@Override
	public String deleteParentDetails(Long parentId) {
		Parent foundParent = parentDao.findById(parentId).orElseThrow();
		parentDao.deleteById(parentId);
		return "Parent Details Deleted Succesfully";
	}

	@Override
	public String addTimeTable(TimeTableDto ttable) {

		Classroom std = classDao.findByStdAndDivision(ttable.getStd(),ttable.getDivision()).orElseThrow(()-> new ResourceNotFoundException("class not found in adminservie"));
		std.getTeachers().size();
		std.getSubjects().size();
		Subject sub = subjectDao.findBySubjectName(ttable.getSubject()).orElseThrow(()-> new ResourceNotFoundException("subject not found in adminservie"));
		
		Timetable timetable = mapper.map(ttable, Timetable.class);
		timetable.setClassroom(std);
		timetable.setSubject(sub);
		ttableDao.save(timetable);
		return "Table Added successfully";
		

	}
	
//	@Override
//	public Result addResult(ResultReqDto request) {
//		
//		System.out.println(request.getExam_name());
//		
//		Exam e = examDao.findByExamName(request.getExam_name())
//				.orElseThrow(() -> new ResourceNotFoundException("Exam details not found in addResult of teaservice"));
//		System.out.println(e);
//
//		Subject su = subjDao.findBySubjectName(request.getSubject_name())
//				.orElseThrow(() -> new ResourceNotFoundException("Subject details not found in addResult of teaservice"));
//		System.out.println(su);
//		
//		Student st = stuDao.findBySFirstName(request.getS_first_name())
//				.orElseThrow(() -> new ResourceNotFoundException("Student details not found in addResult of teaservice"));
//		System.out.println(st);
//		
//		
//		Result r = new Result();
//		r.setExam(e);
//		r.setMarks(request.getMarks());
//		
//		r.setStudent(st);
//		r.setSubject(su);
//		System.out.println(r);
//		
//		return resDao.save(r);
//	}

	@Override
	public Timetable updateTimeTable( Long ttId,TimeTableDto ttable) {
		Timetable foundData = ttableDao.findById(ttId).orElseThrow();
		Classroom classData = classDao.findByStdAndDivision(ttable.getStd(),ttable.getDivision()).orElseThrow();
		classData.getTeachers().size();
		classData.getSubjects().size();
		Subject s= subjectDao.findBySubjectName(ttable.getSubject()).orElseThrow();
		
		Timetable tt = new Timetable();
		tt.setClassroom(classData);
		tt.setDay(ttable.getDay());
		tt.setSubject(s);
		tt.setTime(ttable.getTime());
		tt.setTtId(ttId);

		return ttableDao.save(tt);
	}

	

	@Override
	public String deletTimeTableData(Long ttId) {
		Timetable foundTable = ttableDao.findById(ttId).orElseThrow();
		ttableDao.deleteById(ttId);
		return "Time Table Data Deleted Successfully";
	}

	@Override
	public Classroom addClassroom(ClassroomRequestDto classroom) {
		
        
		return classDao.save(mapper.map(classroom, Classroom.class));
	}

	//	@Override
	//	public Attendance addAttendance(AttendanceRequestDto request) {
	////		Teacher teachId = teacherDao.findById(teacherId).orElseThrow();
	////		Student stdId = adminDao.findById(studentId).orElseThrow();
	////		Attendance attnd = new Attendance();
	////		attnd.setStudent(stdId);
	////		attnd.setTeacher(teachId);
	////		attnd.setStatus(request.isStatus());
	////		attnd.setDate(request.getDate());
	////		attnd.setUserId(request.getUser_id());
	//
	//		
	//		return attendanceDao.save(attnd);
	//
	//	}

	
	@Override
	public String updateClassroomDetails(ClassroomRequestDto classroom) {

	Classroom foundClass = classDao.findById(classroom.getClassroomId()).orElseThrow();
//     foundClass.getSubjects().size();
//     
//     foundClass.getTeachers().size();
	classDao.save(mapper.map(classroom, Classroom.class));

	return "classroom updated successfully" ;

	}
	@Override
	public String deleteClassroomData(Long classroomId) {
	Classroom foundData = classDao.findById(classroomId).orElseThrow();
	
	classDao.deleteById(classroomId);

	return "Deleted Data Successfully";
	}


}
