
package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AttendanceRespDto;
import com.app.dto.AuthRespDTO;
import com.app.dto.AuthreqDTO;
import com.app.dto.ReqIssueDto;
import com.app.dto.ResultRespDto;
import com.app.entities.Student;
import com.app.service.ParentService;

@RestController
@RequestMapping("/parent")
@CrossOrigin(origins = "http://localhost:3000")
public class ParentController {
	@Autowired
	private ParentService parentService;
	
	
	@PostMapping("/signIn")
	public ResponseEntity<?> signInParent(@RequestBody AuthreqDTO request)
	{
		System.out.println(request.toString());
		AuthRespDTO resp=parentService.signInParent(request);
		return ResponseEntity.ok(resp);		
	}
	
	@GetMapping("/results/{parent_id}")
	public ResponseEntity<?> getResultOfStudent(@PathVariable Long parent_id){
		
		
		
		ResultRespDto res = parentService.getResult(parent_id);
		
		System.out.println(res.toString());
		return ResponseEntity.ok(res);
		
	}
	
	@GetMapping("/attendance/{parent_id}")
public ResponseEntity<?> getAttendanceOfStudent(@PathVariable Long parent_id){
		
		
		List<AttendanceRespDto> res = parentService.getAttendance(parent_id);
		
		System.out.println(res.toString());
		return ResponseEntity.ok(res);
		
	}

	@GetMapping("/student/{student_id}")
	public Optional<Student> getChildInfo(@PathVariable Long parent_id)
	{
		Optional<Student> childInfo=parentService.getChildInfo(parent_id);
		
		return childInfo;
		
	}
	
	@PostMapping("/issue/raiseIssue/{parent_id}")
	public String raiseIssue(@PathVariable Long parent_id ,@RequestBody ReqIssueDto issue )
	{
		
		
		String message=parentService.raiseIssue(parent_id,issue);
		
		return message;
		
	}
	

}
