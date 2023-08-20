
  package com.app.service;
  
  import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service; import
  org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminAttendanceDao;
import com.app.dao.AdminDao;
import com.app.dao.AdminParentDao;
import com.app.dao.AdminSubjectDao;
import com.app.dao.AdminTeacherDao;
import com.app.dao.AdminTimeTableDao;
import com.app.dao.ClassroomDao;
import com.app.dto.AttendanceRequestDto;
import com.app.dto.ClassroomRequestDto;
import com.app.dto.SignUpParentDto;
import com.app.dto.TimeTableDto;
import com.app.entities.Attendance;
import com.app.entities.Classroom;
import com.app.entities.Parent;
import com.app.entities.Student;
import com.app.entities.Subject;
//import com.app.entities.Person;
import com.app.entities.Teacher;
import com.app.entities.Timetable;

//import com.app.entities.User;
  
  @Service
  
  @Transactional public class AdminServiceImpl implements AdminService {
  
  @Autowired private AdminDao adminDao;
  @Autowired private AdminTeacherDao teacherDao;
  @Autowired private AdminParentDao parentDao;
  @Autowired private AdminTimeTableDao ttableDao;
  @Autowired private ClassroomDao classDao;
  @Autowired private AdminSubjectDao subjectDao;
  @Autowired private AdminAttendanceDao attendanceDao;
  @Autowired
  private ModelMapper mapper;
@Override
public Student addStudentDetails(Student stud) {
	// TODO Auto-generated method stub
	return adminDao.save(stud);
}
@Override
public Student updateStudentsDetail(Student stud) {
      Student foundStud =adminDao.findById(stud.getStudent_id()).orElseThrow();
      
	return adminDao.save(stud);
}
@Override
public String deleteStudentDetails(Long studentId) {
    Student foundStud =adminDao.findById(studentId).orElseThrow();
    adminDao.deleteById(studentId);
	return "Student Details Deleted Successfully";
}
@Override
public Teacher addTeacherDetails(Teacher teacher) {
	return teacherDao.save(teacher);
	
}
@Override
public Teacher updateTeacherDetails(Teacher teacher) {
	Teacher foundTeacher =teacherDao.findById(teacher.getTeacher_id()).orElseThrow();
	return teacherDao.save(teacher);
}
@Override
public String deleteTeacherDetails(Long teacherId) {
	Teacher foundTeacher =teacherDao.findById(teacherId).orElseThrow();
	teacherDao.deleteById(teacherId);
	return "Teacher Details Deleted Successfully";
}
@Override
public Parent updateParentDetails(SignUpParentDto request) {
	
	Parent foundParent = parentDao.findById(request.getParent_id()).orElseThrow();
	foundParent.getIssue().size();
	Parent parent=mapper.map(request, Parent.class);
	return parentDao.save(parent);
}
@Override
public Parent addParentDetails(SignUpParentDto request) {
	System.out.println(request);
	Parent parent=mapper.map(request, Parent.class);
	System.out.println(parent);
	return parentDao.save(parent);
}
@Override
public String deleteParentDetails(Long parentId) {
	Parent foundParent =parentDao.findById(parentId).orElseThrow();
	parentDao.deleteById(parentId);
	return "Parent Details Deleted Succesfully";
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
@Override
public Timetable updateTimeTable(Long classroom_id, TimeTableDto ttable) {
	Timetable foundData =ttableDao.findById(ttable.getTt_id()).orElseThrow();
	Classroom classData=classDao.findById(classroom_id).orElseThrow();
	classData.getStudent().size();
	Timetable tt=new Timetable();
	tt.setClassroom(classData);
	tt.setDay(ttable.getDay());
	tt.setSubject(ttable.getSubject());
	tt.setTime(ttable.getTime());
	tt.setTt_id(ttable.getTt_id());
	
	return ttableDao.save(tt);
}


/*
 * @Override public Classroom addClassroom(Classroom classroom) { Subject subId
 * =classDao.findB
 * 
 * return }
 */
 
@Override
public String deletTimeTableData(Long ttId) {
	Timetable foundTable =ttableDao.findById(ttId).orElseThrow();
	ttableDao.deleteById(ttId);
	return "Time Table Data Deleted Successfully";
}
@Override
public Classroom addClassroom(Long subjectId, Long teacherId, ClassroomRequestDto classroom) {
	Subject subId =subjectDao.findById(subjectId).orElseThrow();
	Teacher teachId =teacherDao.findById(teacherId).orElseThrow();
	Classroom cls =new Classroom();
	//Classroom cls1 =mapper.map(classroom, Classroom.class);
	cls.setSubject(subId);
	cls.setTeacher(teachId);
	cls.setClassroom_id(classroom.getClassroom_id());
	cls.setDivision(classroom.getDivision());
	cls.setStd(classroom.getStd());
	
	return classDao.save(cls);
}
@Override
public Attendance addAttendance(Long studentId, Long teacherId, AttendanceRequestDto request) {
	Teacher teachId =teacherDao.findById(teacherId).orElseThrow();
	Student stdId =adminDao.findById(studentId).orElseThrow();
	Attendance attnd =new Attendance();
	attnd.setStudent(stdId);
	attnd.setTeacher(teachId);
	attnd.setStatus(request.isStatus());
	attnd.setDate(request.getDate());
	attnd.setUser_id(request.getUser_id());
			
	return attendanceDao.save(attnd);
}
  
	/*
	 * @Override public SignUpResponseDto addStudentDetails(SignUpRequestStudentDto
	 * request) { System.out.println(request); Students stud =mapper.map(request,
	 * Students.class); System.out.println(stud); Students stud1
	 * =adminDao.save(stud); return mapper.map(stud1, SignUpResponseDto.class); }
	 */
  
  }
 
