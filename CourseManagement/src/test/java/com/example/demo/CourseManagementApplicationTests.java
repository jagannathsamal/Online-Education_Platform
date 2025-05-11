package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.controller.CourseController;
import com.example.demo.exception.CourseNotFound;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

class CourseManagementApplicationTests {

    @InjectMocks
    private CourseController courseController;

    @Mock
    private CourseService courseService;

    private Course course;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        course = new Course();
        course.setCourseId(1);
        course.setTitle("Java");
        course.setDescription("Java Basics");
        course.setCategory("Programming");
        course.setInstructorId(101);
    }

    @Test
    void testSaveCourse() {
        when(courseService.saveCourse(course)).thenReturn("course saved successfully.....");
        String result = courseController.saveCourse(course);
        assertEquals("course saved successfully.....", result);
    }

    @Test
    void testUpdateCourse() {
        when(courseService.updateCouse(course)).thenReturn(course);
        Course updated = courseController.updateCouse(course);
        assertEquals(course, updated);
    }

    @Test
    void testGetCourseById() throws CourseNotFound {
        when(courseService.getcourse(1)).thenReturn(course);
        Course result = courseController.getcourse(1);
        assertEquals(course, result);
    }

    @Test
    void testGetAllCourses() {
        List<Course> courses = Arrays.asList(course);
        when(courseService.getAllCourse()).thenReturn(courses);
        List<Course> result = courseController.getAllCourse();
        assertEquals(1, result.size());
    }

    @Test
    void testDeleteCourse() {
        when(courseService.deleteCourse(1)).thenReturn("course deleted successfully......");
        String result = courseController.deleteCourse(1);
        assertEquals("course deleted successfully......", result);
    }

    @Test
    void testExistsById() {
        when(courseService.existsById(1)).thenReturn(true);
        boolean exists = courseController.existsById(1);
        assertTrue(exists);
    }
}
