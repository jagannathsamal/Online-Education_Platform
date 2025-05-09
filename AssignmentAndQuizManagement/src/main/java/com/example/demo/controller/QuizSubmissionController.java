package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.QuizSubmission;
import com.example.demo.repository.QuizSubmissionRepository;
import com.example.demo.service.QuizSubmissionService;

@RestController
@RequestMapping("/submission")
public class QuizSubmissionController {
	
	@Autowired
	QuizSubmissionService service;
	
	@PostMapping("/submit")
	public QuizSubmission evaluateQuiz(QuizSubmission quizSubmission) {
		return service.evaluateQuiz(quizSubmission);
		}
	@GetMapping("/getByUserId/{id}")
	public List<QuizSubmission> getAllQuizSubmissionByUserId(@PathVariable("id") int userId) {
		return service.getAllQuizSubmissionByUserId(userId);
	}
	@GetMapping("/getquiz/{uid}/{qid}")
	public QuizSubmissionRepository getQuizSubmissionByUserId(@PathVariable("uid") int userId,@PathVariable("qid") int quizId) {
		return service.getQuizSubmissionByUserId(userId, quizId);
	}

}
