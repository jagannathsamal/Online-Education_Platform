package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CourseNotFound;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService service;

	@PostMapping("/save")
	public String saveCourse(@RequestBody Course course) {
		return service.saveCourse(course);

	}

	@PutMapping("/update")
	public Course updateCouse(@RequestBody Course course) {
		return service.updateCouse(course);
	}

	@GetMapping("/getById/{id}")
	public Course getcourse(@PathVariable("id") int courseId) throws CourseNotFound {
		return service.getcourse(courseId);

	}

	@GetMapping("/getAll")
	public List<Course> getAllCourse() {
		return service.getAllCourse();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@RequestBody @PathVariable("id") int courseId) {
		return service.deleteCourse(courseId);
	}
	@GetMapping("/existBy/{id}")
	public boolean existsById(@PathVariable("id") int courseId) {
		return service.existsById(courseId);
	}
	@GetMapping("/getContentBy/{id}")
	public String getContentByCourseId(@PathVariable("id") int courseId) {
	    return service.getContentByCourseId(courseId);
	}

}
