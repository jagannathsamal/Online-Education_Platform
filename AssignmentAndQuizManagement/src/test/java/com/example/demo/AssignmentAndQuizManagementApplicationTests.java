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

import com.example.demo.controller.QuizController;
import com.example.demo.dto.QuizResponseDTO;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import com.example.demo.service.QuizService;

class AssignmentAndQuizManagementApplicationTests {

    @InjectMocks
    private QuizController quizController;

    @Mock
    private QuizService quizService;

    private Quiz quiz;
    private QuizSubmission submission;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        quiz = new Quiz();
        submission = new QuizSubmission(1, 1, 101, 1001, Arrays.asList("A1", "A2"), 2, true);
    }

    @Test
    void testSaveQuiz() {
        when(quizService.saveQuiz(quiz)).thenReturn("Quiz added successfully....");
        String result = quizController.saveQuiz(quiz);
        assertEquals("Quiz added successfully....", result);
    }

    @Test
    void testDeleteQuizById() {
        when(quizService.deleteQuizById(1)).thenReturn("Quiz deleted successfully.....");
        String result = quizController.deleteQuizById(1);
        assertEquals("Quiz deleted successfully.....", result);
    }

    @Test
    void testGetQuizById() {
        QuizResponseDTO responseDTO = new QuizResponseDTO(null, quiz);
        when(quizService.getQuizByid(1)).thenReturn(responseDTO);
        QuizResponseDTO result = quizController.getQuizByid(1);
        assertEquals(responseDTO, result);
    }

//    @Test
//    void testUpdateQuiz() {
//        when(quizService.updateQuiz(quiz)).thenReturn(quiz);
//        Quiz result = quizController.updateQuiz(quiz);
//        assertEquals(quiz, result);
//    }

    @Test
    void testGetAllQuizzes() {
        List<Quiz> quizzes = Arrays.asList(quiz);
        when(quizService.getAllQuizzes()).thenReturn(quizzes);
        List<Quiz> result = quizController.getAllQuizzes();
        assertEquals(1, result.size());
    }

    @Test
    void testGetQuizByCourseId() {
        List<Quiz> quizzes = Arrays.asList(quiz);
        when(quizService.getQuizByCourseId(101)).thenReturn(quizzes);
        List<Quiz> result = quizController.getQuizByCourseId(101);
        assertEquals(1, result.size());
    }

    @Test
    void testEvaluateQuiz() {
        when(quizService.evaluateQuiz(submission)).thenReturn(submission);
        QuizSubmission result = quizController.evaluateQuiz(submission);
        assertEquals(submission, result);
    }

    @Test
    void testGetAllQuizSubmissionByUserId() {
        List<QuizSubmission> submissions = Arrays.asList(submission);
        when(quizService.getAllQuizSubmissionByUserId(1001)).thenReturn(submissions);
        List<QuizSubmission> result = quizController.getAllQuizSubmissionByUserId(1001);
        assertEquals(1, result.size());
    }

    @Test
    void testGetQuizSubmissionByUserId() {
        when(quizService.getQuizSubmissionByUserId(1001, 1)).thenReturn(submission);
        QuizSubmission result = quizController.getQuizSubmissionByUserId(1001, 1);
        assertEquals(submission, result);
    }
}
