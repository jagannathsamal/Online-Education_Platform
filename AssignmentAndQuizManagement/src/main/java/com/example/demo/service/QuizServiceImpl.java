package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Course;
import com.example.demo.dto.QuizResponseDTO;
import com.example.demo.feignclient.CourseClient;
import com.example.demo.feignclient.UserClient;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import com.example.demo.repository.QuizRepository;
import com.example.demo.repository.QuizSubmissionRepository;

@Service
public class QuizServiceImpl implements QuizService {

	
	@Autowired
	QuizRepository repository;
	
	@Autowired
	CourseClient courseClient;

	@Autowired
	UserClient userClient;
	
	@Autowired
	QuizSubmissionRepository submissionrepository;

	@Override
	public String saveQuiz(Quiz quiz) {
		courseClient.existsById(quiz.getCourseId());
		repository.save(quiz);
		return "Quiz added successfully....";
		
	}

	@Override
	public String deleteQuizById(int quizId) {
		repository.deleteById(quizId);
		return "Quiz deleted successfully.....";
	}

	@Override
	public QuizResponseDTO getQuizByid(int quizId) {
		Quiz quiz=repository.findById(quizId).get();
		int courseId=quiz.getQuizId();
		Course course= courseClient.getcourse(courseId);
		QuizResponseDTO responseDTO=new QuizResponseDTO(course,quiz);
		return responseDTO;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return repository.save(quiz);
	}

//	@Override
//	public QuizSubmission evaluateQuiz(QuizSubmission quizSubmission) {
//		Boolean response = userClient.existsById(quizSubmission.getUserId());
//		 
//		Quiz quiz = repository.findById(quizSubmission.getQuizId()).get();
//		int score = 0;
//		List<String> correctAnswers = quiz.getCorrectAnswer();
//		for (int i = 0; i < quizSubmission.getResponses().size(); i++) {
//			boolean isCorrect = quizSubmission.getResponses().get(i).equalsIgnoreCase(correctAnswers.get(i));
//			if (isCorrect) {
//				score += 10;
//			}
//		}
//		quizSubmission.setScore(score);
//		quizSubmission.setPassed(score >= quiz.getTotalMarks()*(0.5));// Passing criteria: 60%
//		submissionrepository.save(quizSubmission);
//		return quizSubmission;
//		
//	}

	@Override
	public List<Quiz> getAllQuizzes() {
		return repository.findAll();
	}


	@Override
	public List<Quiz> getQuizByCourseId(int courseId) {
		return repository.findByCourseId(courseId);
	}

//	@Override
//	public QuizSubmissionRepository getQuizSubmissionByUserId(int userId, int quizId) {
//		return submissionrepository.findByUserIdAndQuizId(userId,quizId);
//	}

//	@Override
//	public List<QuizSubmission> getAllQuizSubmissionByUserId(int userId) {
//		return submissionrepository.findByUserId(userId);
//	}

}
