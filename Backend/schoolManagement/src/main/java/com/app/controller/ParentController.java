package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRespDTO;
import com.app.dto.AuthreqDTO;
import com.app.service.ParentService;

@RestController
@RequestMapping("/parent")
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
	
	

}
