package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.Course;

@FeignClient(name="COURSEMANAGEMENT",path = "/course")
public interface CourseClient {
	@GetMapping("/existBy/{id}")
	public boolean existsById(@PathVariable("id") int courseId);
	@GetMapping("/getById/{id}")
	public Course getcourse(@PathVariable("id") int courseId);
	
	
}
