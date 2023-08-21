package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AttendanceReqDto;
import com.app.dto.IssueReqDto;
import com.app.dto.ResultReqDto;
import com.app.dto.TimeTableDto;
import com.app.entities.Result;
import com.app.entities.Timetable;
import com.app.service.TeacherService;


@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teaService;
	

	
	
	@PostMapping("/result")
	public ResponseEntity<?> addStudentResult(@RequestBody ResultReqDto request){
		
		System.out.println(request);
		
		Result r = teaService.addResult(request);
		
		if(r!=null) {
			return ResponseEntity.ok(new ApiResponse("Result added successfully"));
		}
		else
		return ResponseEntity.status(404).body(new ApiResponse("Result addition failed"));
	}
	
	@GetMapping("/issue")
	public ResponseEntity<?> viewAllIssue(){
		
		
		return ResponseEntity.ok(teaService.viewAllIssue());
		
	}

	@PutMapping("/issue/{issue_id}")
	public ResponseEntity<?> handleIssue(@PathVariable Long issue_id, IssueReqDto request){
	
		
		return ResponseEntity.ok(teaService.handleIssue(issue_id , request));
		
	}
	
	
	@PostMapping("/attendance") 
	public ResponseEntity<?> addAttendance(@RequestBody  AttendanceReqDto request) {
	  
	  return ResponseEntity.ok(teaService.addAttendance(request));
	  
	  }
	
	
	@PostMapping("/timetable/{classroom_id}")
	  public Timetable addNewTimetable(@PathVariable Long classroom_id, @RequestBody TimeTableDto ttable) {
		  
		  
		     return teaService.addTimeTable(classroom_id,ttable);
	  }
}













