package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EnrollmentRepository;
import com.example.demo.dto.Course;
import com.example.demo.dto.EnrollmentResponseDTO;
import com.example.demo.exception.EnrollmentNotFound;
import com.example.demo.feignclient.CourseClient;
import com.example.demo.feignclient.UserClient;
import com.example.demo.model.Enrollment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private static final Logger logger = LoggerFactory.getLogger(EnrollmentServiceImpl.class);

    @Autowired
    EnrollmentRepository repository;

    @Autowired
    UserClient userClient;

    @Autowired
    CourseClient courseClient;

    @Override
    public String saveEnrollment(Enrollment enrollment) {
        logger.info("Attempting to save enrollment: {}", enrollment);

        if (!userClient.existsById(enrollment.getUserId())) {
            logger.warn("User ID {} not found", enrollment.getUserId());
            return "UserId or courseId Not Found";
        }

        if (!courseClient.existsById(enrollment.getCourseId())) {
            logger.warn("Course ID {} not found", enrollment.getCourseId());
            return "UserId or courseId Not Found";
        }

        // Check if the enrollment already exists
        if (repository.existsByUserIdAndCourseId(enrollment.getUserId(), enrollment.getCourseId())) {
            logger.info("User {} is already enrolled in course {}", enrollment.getUserId(), enrollment.getCourseId());
            return "You are already enrolled in this course.";
        }

        repository.save(enrollment);
        logger.info("Enrollment saved successfully: {}", enrollment);
        return "Enrollment saved successfully.";
    }


    @Override
    public String deleteEnrollment(int enrollmentId) {
        logger.info("Attempting to delete enrollment with ID: {}", enrollmentId);
        repository.deleteById(enrollmentId);
        logger.info("Enrollment deleted successfully.");
        return "Enrollment deleted";
    }

    @Override
    public EnrollmentResponseDTO getEnrollment(int enrollmentId) throws EnrollmentNotFound {
        logger.info("Fetching enrollment with ID: {}", enrollmentId);
        Enrollment enrollment = repository.findById(enrollmentId)
                .orElseThrow(() -> {
                    logger.error("Enrollment not found with ID: {}", enrollmentId);
                    return new EnrollmentNotFound("Enrollment not found with ID: " + enrollmentId);
                });

        int courseId = enrollment.getCourseId();
        Course course = courseClient.getcourse(courseId);

        logger.info("Successfully retrieved enrollment for ID: {}", enrollmentId);
        return new EnrollmentResponseDTO(course, enrollment);
    }

    @Override
    public List<Course> getCourseByUserId(int userId) {
        logger.info("Fetching courses for user ID: {}", userId);
        List<Enrollment> list = repository.findByUserId(userId);
        List<Course> courses = new ArrayList<>();

        for (Enrollment enroll : list) {
            logger.info("Fetching course details for course ID: {}", enroll.getCourseId());
            courses.add(courseClient.getcourse(enroll.getCourseId()));
        }

        logger.info("Successfully fetched courses for user ID: {}", userId);
        return courses;
    }

    @Override
    public List<Enrollment> findByCourseId(int courseId) {
        logger.info("Fetching enrollments for course ID: {}", courseId);
        return repository.findByCourseId(courseId);
    }


	@Override
	public boolean existsByUserIdAndCourseId(int userId, int courseId) {
		return repository.existsByUserIdAndCourseId(userId, courseId);
	}


	@Override
	public List<Enrollment> findAll() {
		return repository.findAll();
	}
}
