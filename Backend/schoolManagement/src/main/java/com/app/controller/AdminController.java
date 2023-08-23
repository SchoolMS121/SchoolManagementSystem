
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
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
import com.app.service.AdminService;

@RestController

@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/students")
	public ResponseEntity<?> addNewStudent(@RequestBody StudentReqDto stud) {
		return ResponseEntity.ok(new ApiResponse(adminService.addStudentDetails(stud))) ;
	}

	@PutMapping("/students")
	public ResponseEntity<?> updateStudentDetails(@RequestBody StudentReqDto stud) {
		return ResponseEntity.ok(adminService.updateStudentsDetail(stud));
	}

	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<?> deleteStudentDetails(@PathVariable Long studentId) {
		return ResponseEntity.ok(new ApiResponse(adminService.deleteStudentDetails(studentId)));
	}

	@PostMapping("/teacher")
	public ResponseEntity<?> addNewTeacher(@RequestBody TeacherReqDto teacher) {
		return ResponseEntity.ok(adminService.addTeacherDetails(teacher));
	}

	@PutMapping("/teacher")
	public ResponseEntity<?> updateTeacherDetails(@RequestBody TeacherReqDto teacher) {
		return ResponseEntity.ok(adminService.updateTeacherDetails(teacher));
	}

	@DeleteMapping("/teacher/{std}/{div}/{teacherId}")
	public ResponseEntity<?> deleteteacherDetails(@PathVariable int std,@PathVariable String div, @PathVariable Long teacherId) {
		return ResponseEntity.ok(new ApiResponse(adminService.deleteTeacherDetails(std,div, teacherId)));
	}

	@PutMapping("/parent")
	public ResponseEntity<?> updateParentDetails(@RequestBody SignUpParentDto parent) {
		return ResponseEntity.ok(adminService.updateParentDetails(parent));
	}

	@PostMapping("/parent")
	public ResponseEntity<?> addNewParent(@RequestBody ParentReqDto parent) {
		return ResponseEntity.ok(adminService.addParentDetails(parent));
	}

	@DeleteMapping("/parent/{parentId}")
	public ResponseEntity<?> deleteParentDetails(@PathVariable Long parentId) {
		return ResponseEntity.ok(new ApiResponse(adminService.deleteParentDetails(parentId)));
	}

	@PostMapping("/timetable")
	public ResponseEntity<?> addNewTimetable(@RequestBody TimeTableDto ttable) {

		return ResponseEntity.ok(adminService.addTimeTable(ttable));
	}

	@PutMapping("/timetable/{ttId}")
	public ResponseEntity<?> updateTimetable(@PathVariable Long ttId, @RequestBody TimeTableDto ttable) {

		return ResponseEntity.ok(adminService.updateTimeTable(ttId, ttable));
	}

	@DeleteMapping("/timetable/{ttId}")
	public ResponseEntity<?> deleteTimeTableData(@PathVariable Long ttId) {
		return ResponseEntity.ok(new ApiResponse(adminService.deletTimeTableData(ttId)));
	}

	@PostMapping("/addClassroom/")
	public ResponseEntity<?> addClassroom(@RequestBody ClassroomRequestDto classroom) {

		return ResponseEntity.ok(adminService.addClassroom(classroom));

	}

//	@PostMapping("/attendance/{studentId}/{teacherId}")
//	public Attendance addAttendance(@PathVariable Long studentId, @PathVariable Long teacherId,
//			@RequestBody AttendanceRequestDto classroom) {
//
//		return adminService.addAttendance(studentId, teacherId, classroom);
//
//	}

	@PutMapping("/updateClassroom/{classroomId}")
	public ResponseEntity<?> updateClassroom( @RequestBody ClassroomRequestDto classroom) {
		return ResponseEntity.ok(adminService.updateClassroomDetails(classroom));
	}

	@DeleteMapping("/deleteClassroom/{classroomId}")
	public ResponseEntity<?> deleteClassroomData(@PathVariable Long classroomId) {
		return ResponseEntity.ok(new ApiResponse(adminService.deleteClassroomData(classroomId)));
	}

}
