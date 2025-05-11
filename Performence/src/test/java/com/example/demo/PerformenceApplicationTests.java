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

import com.example.demo.controller.PerformenceController;
import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.CourseProgressDTO;
import com.example.demo.dto.QuizProgressDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.PerformenceService;

class PerformenceApplicationTests {

    @InjectMocks
    private PerformenceController performenceController;

    @Mock
    private PerformenceService performenceService;

    private CourseDTO courseDTO;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        courseDTO = new CourseDTO(101, "Java", "Learn Java Basics","programming", 1);
        QuizProgressDTO quizProgress = new QuizProgressDTO(1, 10, 8, 80.0);
        CourseProgressDTO courseProgress = new CourseProgressDTO(101, "Java", "Learn Java Basics", Arrays.asList(quizProgress));
        userDTO = new UserDTO(1, Arrays.asList(courseProgress));
    }

    @Test
    void testGetCourseByUserId() {
        when(performenceService.getCourseByUserId(1)).thenReturn(Arrays.asList(courseDTO));
        List<CourseDTO> result = performenceController.getCourseByUserId(1);
        assertEquals(1, result.size());
        assertEquals("Java", result.get(0).getTitle());
    }

    @Test
    void testGetProgressByUserId() {
        when(performenceService.getProgressByUserId(1)).thenReturn(userDTO);
        UserDTO result = performenceController.getProgressByUserId(1);
        assertEquals(1, result.getUserId());
        assertEquals(1, result.getCourses().size());
    }
}
