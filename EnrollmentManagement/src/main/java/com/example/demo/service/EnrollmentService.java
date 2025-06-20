package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Course;
import com.example.demo.dto.EnrollmentResponseDTO;
import com.example.demo.exception.EnrollmentNotFound;
import com.example.demo.model.Enrollment;

public interface EnrollmentService {
	public abstract String saveEnrollment(Enrollment enrollment);
	
	public abstract String deleteEnrollment(int enrollmentId);
	
	public abstract EnrollmentResponseDTO getEnrollment(int enrollmentId) throws EnrollmentNotFound;
	
	public abstract List<Course> getCourseByUserId(int usrId);
	
	public abstract List<Enrollment> findByCourseId(int courseId);
	
	public abstract List<Enrollment> findAll();
	
	boolean existsByUserIdAndCourseId(int userId, int courseId);


}
