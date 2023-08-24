package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AttendanceRespDto;
import com.app.dto.LoginReqDto;
import com.app.dto.LoginRespDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	@Autowired
	private StudentService stdService;
	@Autowired
	private ModelMapper mapper;
	
	//Login
	@PostMapping("/login")
	public  ResponseEntity<?> loginStudent(@RequestBody LoginReqDto request){
		
		System.out.println(request.toString());
		
		LoginRespDto resp= stdService.loginStudent(request);
		
		return ResponseEntity.ok(resp);
	}
	
	
	@GetMapping("/results/{student_id}")
	public ResponseEntity<?> getResultOfStudent(@PathVariable Long student_id){
		
		
		ResultRespDto res = stdService.getResult(student_id);
		
		System.out.println(res.toString());
		return ResponseEntity.ok(res);
		
	}
	
	@GetMapping("/attendance/{student_id}")
public ResponseEntity<?> getAttendanceOfStudent(@PathVariable Long student_id){
		
		
		List<AttendanceRespDto> res = stdService.getAttendance(student_id);
		
		System.out.println(res.toString());
		return ResponseEntity.ok(res);
		
	}
}













