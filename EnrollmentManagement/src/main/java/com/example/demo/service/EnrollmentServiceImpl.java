package com.example.demo.service;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EnrollmentRepository;
import com.example.demo.dto.Course;
import com.example.demo.dto.EnrollmentResponseDTO;
import com.example.demo.feignclient.CourseClient;
import com.example.demo.feignclient.UserClient;
import com.example.demo.model.Enrollment;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	private static final Enrollment enrollment = null;

	@Autowired
	EnrollmentRepository repository;
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	CourseClient courseClient;

	@Override
	public String saveEnrollment(Enrollment enrollment) {
        if(!userClient.existsById(enrollment.getUserId())) {
        	return "UserId or courseId Not Found";
        }
        
        if(!courseClient.existsById(enrollment.getCourseId())) {
        	return "UserId or courseId Not Found";
        }
	
  
            repository.save(enrollment);
            return "Enrollment saved successfully.";
        
    }

	@Override
	public String deleteEnrollment(int enrollmentId) {
		repository.deleteById(enrollmentId);;
		return "enrollment deleted";
	}

	@Override
	public EnrollmentResponseDTO getEnrollment(int enrollmentId) {
		Enrollment enrollment=repository.findById(enrollmentId).get();
		int courseId=enrollment.getCourseId();
		Course course= courseClient.getcourse(courseId);
		EnrollmentResponseDTO responseDTO=new EnrollmentResponseDTO(course,enrollment);
		return responseDTO;
		
	}

	@Override
	public List<Course> getCourseByUserId(int userId) {
		List<Enrollment> list = repository.findByUserId(userId);
		List<Course> courses = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Enrollment enroll = list.get(i);
			courses.add(courseClient.getcourse(enroll.getCourseId()));
		}

		return courses;
	}

	@Override
	public List<Enrollment> findByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}


}
