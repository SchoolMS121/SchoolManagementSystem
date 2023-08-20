
  package com.app.service;
  
  

import com.app.dto.AttendanceRequestDto;
import com.app.dto.ClassroomRequestDto;
import com.app.dto.SignUpParentDto;
import com.app.dto.TimeTableDto;
import com.app.entities.Attendance;
import com.app.entities.Classroom;
import com.app.entities.Parent;
import com.app.entities.Student;
import com.app.entities.Teacher;
import com.app.entities.Timetable;

  
  public interface AdminService { 
	 // SignUpResponseDto addStudentDetails(SignUpRequestStudentDto stud);
	  Student addStudentDetails(Student stud);
	  Student updateStudentsDetail(Student stud);
	  String deleteStudentDetails(Long studentId);
	  Teacher addTeacherDetails(Teacher teacher);
	  
	  Teacher updateTeacherDetails(Teacher teacher);
	  
	  String deleteTeacherDetails(Long teacherId);
	  
	  Parent updateParentDetails(SignUpParentDto parent);
	  
	  Parent addParentDetails(SignUpParentDto parent);
	  
	  String deleteParentDetails(Long parentId);
	  
	 
	Timetable addTimeTable(Long classroom_id, TimeTableDto ttable);
	Timetable updateTimeTable(Long classroom_id, TimeTableDto ttable);
	Classroom addClassroom(Long subjectId, Long teacherId, ClassroomRequestDto classroom);
	String deletTimeTableData(Long ttId);
	Attendance addAttendance(Long studentId, Long teacherId, AttendanceRequestDto classroom);
  }
 