package com.example.demo.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CourseDTO;

@FeignClient(name="ENROLLMENTMANAGEMENT",path="/enrollment")
public interface EnrollmentClient {
	@GetMapping("/getByUserId/{id}")
	public List<CourseDTO> getCourseByUserId(@PathVariable("id") int userId);

}
