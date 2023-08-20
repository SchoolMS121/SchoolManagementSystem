
  package com.app.controller;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import
  org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
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
import com.app.service.AdminService;

  
  @RestController
  
  @RequestMapping("/admin") 
  public class AdminController {
  
  @Autowired private AdminService adminService;
  

  /*public ResponseEntity<?> addNewStudent(@RequestBody SignUpRequestStudentDto stud) {
	SignUpResponseDto resp  =adminService.addStudentDetails(stud); 
	
  return ResponseEntity.status(HttpStatus.CREATED).body(resp);
  } */
  @PostMapping("/students") 
  public Student addNewStudent (@RequestBody Student stud) {
	  return adminService.addStudentDetails(stud);
  }
  @PutMapping("/students")
  public Student updateStudentDetails(@RequestBody Student stud) {
	  return adminService.updateStudentsDetail(stud);
  }
  @DeleteMapping("/students/{studentId}")
  public ApiResponse deleteStudentDetails(@PathVariable Long studentId) {
	  return new ApiResponse( adminService.deleteStudentDetails(studentId));
  }
  @PostMapping("/teacher") 
  public Teacher addNewTeacher (@RequestBody Teacher teacher) {
	  return adminService.addTeacherDetails(teacher);
  }
  
  @PutMapping("/teacher")
  public Teacher updateTeacherDetails(@RequestBody Teacher teacher) {
	  return adminService.updateTeacherDetails(teacher);
  }
  
  @DeleteMapping("/teacher/{teacherId}")
  public ApiResponse deleteteacherDetails(@PathVariable Long teacherId) {
	  return new ApiResponse( adminService.deleteTeacherDetails(teacherId));
  }
  @PutMapping("/parent")
  public Parent updateParentDetails(@RequestBody SignUpParentDto parent) {
	  return adminService.updateParentDetails(parent);
  }
  
  @PostMapping("/parent") 
  public Parent addNewParent (@RequestBody SignUpParentDto parent) {
	  return adminService.addParentDetails(parent);
  }
  
  @DeleteMapping("/parent/{parentId}")
  public ApiResponse deleteParentDetails(@PathVariable Long parentId) {
	  return new ApiResponse( adminService.deleteParentDetails(parentId));
  }
  
  @PostMapping("/timetable/{classroom_id}")
  public Timetable addNewTimetable(@PathVariable Long classroom_id, @RequestBody TimeTableDto ttable) {
	  
	  
	     return adminService.addTimeTable(classroom_id,ttable);
  }
  @PutMapping("/timetable/{classroom_id}")
  public Timetable updateTimetable(@PathVariable Long classroom_id, @RequestBody TimeTableDto ttable) {
	  
	  
	     return adminService.updateTimeTable(classroom_id,ttable);
  }
  @DeleteMapping("/timetable/{ttId}")
  public ApiResponse deleteTimeTableData(@PathVariable Long ttId) 
  {
	  return new ApiResponse(adminService.deletTimeTableData(ttId));
  }
  
	
	  @PostMapping("/addClassroom/{subjectId}/{teacherId}") 
	  public Classroom addClassroom(@PathVariable Long subjectId,@PathVariable Long teacherId,@RequestBody  ClassroomRequestDto classroom) {
	  
	  return adminService.addClassroom(subjectId,teacherId,classroom);
	  
	  }
	  @PostMapping("/attendance/{studentId}/{teacherId}") 
	  public Attendance addAttendance(@PathVariable Long studentId,@PathVariable Long teacherId,@RequestBody  AttendanceRequestDto classroom) {
	  
	  return adminService.addAttendance(studentId,teacherId,classroom);
	  
	  }
  }
 
