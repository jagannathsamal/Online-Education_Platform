package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.PerformenceService;

@RestController
@RequestMapping("/performence")
public class PerformenceController {
	@Autowired
	PerformenceService service;
	
	@GetMapping("/getCourseByUserId/{id}")
	public List<CourseDTO> getCourseByUserId(@PathVariable("id") int userId) {
		return service.getCourseByUserId(userId);
	}

	@GetMapping("/getProgressByUserId/{id}")
	public UserDTO getProgressByUserId(@PathVariable("id") int userId) {
		return service.getProgressByUserId(userId);
		
	}

}
