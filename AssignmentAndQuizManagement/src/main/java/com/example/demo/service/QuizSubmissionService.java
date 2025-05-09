package com.example.demo.service;

import java.util.List;

import com.example.demo.model.QuizSubmission;
import com.example.demo.repository.QuizSubmissionRepository;

public interface QuizSubmissionService {
	public abstract QuizSubmission evaluateQuiz(QuizSubmission quizSubmission);
	public abstract List<QuizSubmission> getAllQuizSubmissionByUserId(int userId);
	public abstract QuizSubmissionRepository getQuizSubmissionByUserId(int userId, int quizId);

}
