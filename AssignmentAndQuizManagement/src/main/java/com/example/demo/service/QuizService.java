package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.QuizResponseDTO;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import com.example.demo.repository.QuizSubmissionRepository;

public interface QuizService {
	public abstract String saveQuiz(Quiz quiz);
	
	public abstract String deleteQuizById(int quizId);
	
	public abstract QuizResponseDTO getQuizByid(int quizId);
	 
	public abstract Quiz updateQuiz(Quiz quiz);
 
//	public abstract QuizSubmission evaluateQuiz(QuizSubmission quizSubmission);
 
	public abstract List<Quiz> getAllQuizzes();
 
//	public abstract List<QuizSubmission> getAllQuizSubmissionByUserId(int userId);
	
	public abstract List<Quiz> getQuizByCourseId(int courseId);
 
//	public abstract QuizSubmissionRepository getQuizSubmissionByUserId(int userId, int quizId);

}
