
  package com.app.service;
  
  

import com.app.dto.ClassroomRequestDto;
import com.app.dto.ParentReqDto;
import com.app.dto.SignUpParentDto;
import com.app.dto.StudentReqDto;
import com.app.dto.TeacherReqDto;
import com.app.dto.TimeTableDto;
import com.app.entities.Classroom;
import com.app.entities.Parent;
import com.app.entities.Student;
import com.app.entities.Teacher;
import com.app.entities.Timetable;

  
  public interface AdminService { 
	 // SignUpResponseDto addStudentDetails(SignUpRequestStudentDto stud);
	  String addStudentDetails(StudentReqDto stud);
	  String updateStudentsDetail(StudentReqDto stud);
	  String deleteStudentDetails(Long studentId);
	  
	  
	  
	  String addTeacherDetails(TeacherReqDto teacher);
	  
	  Teacher updateTeacherDetails(TeacherReqDto teacher);
	  
	  String deleteTeacherDetails(int std ,String division, Long teacherId);
	  
	 
	 Parent updateParentDetails(SignUpParentDto parent);
	  
	  Parent addParentDetails(ParentReqDto parent);
	  
	  String deleteParentDetails(Long parentId);
	  
	 
	String addTimeTable(TimeTableDto ttable);
	Timetable updateTimeTable( Long ttId, TimeTableDto ttable);
	String deletTimeTableData(Long ttId);
	
	Classroom addClassroom(ClassroomRequestDto classroom);
	
//	Attendance addAttendance(AttendanceRequestDto classroom);
	String deleteClassroomData(Long classroomId);
	String updateClassroomDetails(ClassroomRequestDto classroom);
  }
 