package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.controller.EnrollmentController;
import com.example.demo.dto.Course;
import com.example.demo.dto.EnrollmentResponseDTO;
import com.example.demo.exception.EnrollmentNotFound;
import com.example.demo.model.Enrollment;
import com.example.demo.service.EnrollmentService;

class EnrollmentManagementApplicationTests {

    @InjectMocks
    private EnrollmentController enrollmentController;

    @Mock
    private EnrollmentService enrollmentService;

    private Enrollment enrollment;
    private Course course;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        enrollment = new Enrollment(1, 101, 201);
        course = new Course(201, "Java", "Programming", "Learn Java", 101);
    }

    @Test
    void testSaveEnrollment() {
        when(enrollmentService.saveEnrollment(enrollment)).thenReturn("Enrollment saved successfully.");
        String result = enrollmentController.saveEnrollment(enrollment);
        assertEquals("Enrollment saved successfully.", result);
    }

    @Test
    void testDeleteEnrollment() {
        when(enrollmentService.deleteEnrollment(1)).thenReturn("enrollment deleted");
        String result = enrollmentController.deleteEnrollment(1);
        assertEquals("enrollment deleted", result);
    }

    @Test
    void testGetEnrollment() throws EnrollmentNotFound {
        EnrollmentResponseDTO responseDTO = new EnrollmentResponseDTO(course, enrollment);
        when(enrollmentService.getEnrollment(1)).thenReturn(responseDTO);
        EnrollmentResponseDTO result = enrollmentController.getEnrollment(1);
        assertEquals(responseDTO, result);
    }

    @Test
    void testGetCourseByUserId() {
        List<Course> courses = Arrays.asList(course);
        when(enrollmentService.getCourseByUserId(101)).thenReturn(courses);
        List<Course> result = enrollmentController.getCourseByUserId(101);
        assertEquals(1, result.size());
        assertEquals("Java", result.get(0).getTitle());
    }
}

