package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.CourseProgressDTO;
import com.example.demo.dto.QuizDTO;
import com.example.demo.dto.QuizProgressDTO;
import com.example.demo.dto.QuizSubmissionDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.feignclient.EnrollmentClient;
import com.example.demo.feignclient.QuizClient;

@Service
public class PerformenceServiceImpl implements PerformenceService{
	
	@Autowired
	EnrollmentClient enrollmentClient;
	
	@Autowired
	QuizClient quizClient;
	
//	@Autowired
//	UserClient userClient;
	
	@Override
	public List<CourseDTO> getCourseByUserId(int userId) {
		return enrollmentClient.getCourseByUserId(userId);
	}

	@Override
	public UserDTO getProgressByUserId(int userId) {
		List<CourseDTO> courses = enrollmentClient.getCourseByUserId(userId);
		List<CourseProgressDTO> courseProgressDTOs = new ArrayList<>();
		for(CourseDTO course:courses) {
			int courseId = course.getCourseId();
			List<QuizDTO> quizzes =  quizClient.getQuizByCourseId(courseId);
			List<QuizProgressDTO> quizProgressDTOs = new ArrayList<>();
			for(QuizDTO quiz:quizzes) {
				QuizSubmissionDTO submissionDTO = quizClient.getQuizSubmissionByUserId(userId,quiz.getQuizId());
				int totalMarks = quiz.getTotalMarks();
				int score = submissionDTO!=null?submissionDTO.getScore():0;
                double progressPercentage = (double) score / totalMarks * 100;
                quizProgressDTOs.add(new QuizProgressDTO(quiz.getQuizId(),totalMarks,score,progressPercentage));				
			}
			courseProgressDTOs.add(new CourseProgressDTO(courseId,course.getTitle(),course.getDescription(), quizProgressDTOs));
		}
		return new UserDTO(userId,courseProgressDTOs);
	}

	
	
	


}
