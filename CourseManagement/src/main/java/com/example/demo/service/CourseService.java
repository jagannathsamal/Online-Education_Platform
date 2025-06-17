package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.CourseNotFound;
import com.example.demo.model.Course;

public interface CourseService {
	public abstract String saveCourse(Course course);
	
	public abstract Course updateCouse(Course course);
	
	public abstract Course getcourse(int courseId) throws CourseNotFound;
	
	public abstract List<Course> getAllCourse();
	
	public abstract String deleteCourse(int courseId);
	
	public abstract boolean existsById(int courseId);
	
	public abstract String getContentByCourseId(int courseId);
	

}
