package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AssignmentRequestDTO;
import com.example.demo.dto.AssignmentResponseDTO;
import com.example.demo.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	
	@Autowired
	AssignmentService service;
	@PostMapping("/save")
	public String saveAssignment(@RequestBody AssignmentRequestDTO request) {
		return service.saveAssignment(request);
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteAssignment(@PathVariable("id") int assignmentId) {
		return service.deleteAssignment(assignmentId);
	}
	@GetMapping("/GetById/{id}")
	public AssignmentResponseDTO getAssignmentById(@PathVariable("id") int assignmentId) {
		return service.getAssignmentById(assignmentId);
		
	}
	

}
