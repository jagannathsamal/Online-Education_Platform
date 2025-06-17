package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Course;
import com.example.demo.dto.EnrollmentResponseDTO;
import com.example.demo.exception.EnrollmentNotFound;
import com.example.demo.model.Enrollment;
import com.example.demo.service.EnrollmentService;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	EnrollmentService service;
	
	@PostMapping("/save")
	public String saveEnrollment(@RequestBody Enrollment enrollment) {
		return service.saveEnrollment(enrollment);
	}
	@DeleteMapping("deleteById/{id}")
	public String deleteEnrollment(@PathVariable int enrollmentId) {
		return service.deleteEnrollment(enrollmentId);
	}
	@GetMapping("/getById/{id}")
	public EnrollmentResponseDTO getEnrollment(@PathVariable("id") int enrollmentId) throws EnrollmentNotFound {
		return service.getEnrollment(enrollmentId);
		
	}
	@GetMapping("/getByUserId/{id}")
	public List<Course> getCourseByUserId(@PathVariable("id") int userId) {
		return service.getCourseByUserId(userId);
		
	}
	@GetMapping("/getByCourseId/{id}")
	public List<Enrollment> findByCourseId(@PathVariable("id") int courseId) {
		return service.findByCourseId(courseId);
	}
	@GetMapping("/getAll")
	public List<Enrollment> findAll() {
	    return service.findAll();
	}

	
}
