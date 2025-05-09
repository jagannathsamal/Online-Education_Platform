package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.UserDTO;

public interface PerformenceService {
	public abstract List<CourseDTO> getCourseByUserId(int userId);

	public abstract UserDTO getProgressByUserId(int userId);

}
