package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.feignclient.CourseClient;
import com.example.demo.feignclient.UserClient;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import com.example.demo.repository.QuizRepository;
import com.example.demo.repository.QuizSubmissionRepository;

@Service
public class QuizSubmissionServiceImpl implements QuizSubmissionService {
	
	@Autowired
	QuizRepository repository;
	
	@Autowired
	CourseClient courseClient;

	@Autowired
	UserClient userClient;
	
	@Autowired
	QuizSubmissionRepository submissionrepository;

	@Override
	public QuizSubmission evaluateQuiz(QuizSubmission quizSubmission) {
		Boolean response = userClient.existsById(quizSubmission.getUserId());
		 
		Quiz quiz = repository.findById(quizSubmission.getQuizId()).get();
		int score = 0;
		List<String> correctAnswers = quiz.getCorrectAnswer();
		for (int i = 0; i < quizSubmission.getResponses().size(); i++) {
			boolean isCorrect = quizSubmission.getResponses().get(i).equalsIgnoreCase(correctAnswers.get(i));
			if (isCorrect) {
				score += 10;
			}
		}
		quizSubmission.setScore(score);
		quizSubmission.setPassed(score >= quiz.getTotalMarks()*(0.5));// Passing criteria: 60%
		submissionrepository.save(quizSubmission);
		return quizSubmission;
		
	}

	@Override
	public List<QuizSubmission> getAllQuizSubmissionByUserId(int userId) {
		return submissionrepository.findByUserId(userId);
	}

	@Override
	public QuizSubmissionRepository getQuizSubmissionByUserId(int userId, int quizId) {
		return submissionrepository.findByUserIdAndQuizId(userId,quizId);
	}

}
