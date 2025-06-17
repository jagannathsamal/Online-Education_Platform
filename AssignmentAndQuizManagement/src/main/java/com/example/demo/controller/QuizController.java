package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.QuizResponseDTO;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import com.example.demo.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@PostMapping("/save")
	public String saveQuiz(@RequestBody Quiz quiz) {
		return service.saveQuiz(quiz);
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteQuizById(@PathVariable("id") int quizId) {
		return service.deleteQuizById(quizId);
	}
	@GetMapping("/getById/{id}")
	public QuizResponseDTO getQuizByid(@PathVariable("id") int quizId) {
		return service.getQuizByid(quizId);
	}
	@PutMapping("/update")
	public String updateQuiz(@RequestBody Quiz quiz) {
		return service.updateQuiz(quiz);
	}
	@GetMapping("/getAll")
	public List<Quiz> getAllQuizzes() {
		return service.getAllQuizzes();
	}
	@GetMapping("/getQuizByCourseId/{id}")
	public List<Quiz> getQuizByCourseId(@PathVariable("id") int courseId) {
		return service.getQuizByCourseId(courseId);
	}
	@PostMapping("/submit")
	public QuizSubmission evaluateQuiz(@RequestBody QuizSubmission quizSubmission) {
		return service.evaluateQuiz(quizSubmission);
		}
	@GetMapping("/getByUserId/{id}")
	public List<QuizSubmission> getAllQuizSubmissionByUserId(@PathVariable("id") int userId) {
		return service.getAllQuizSubmissionByUserId(userId);
	}
	@GetMapping("/getquiz/{uid}/{qid}")
	public QuizSubmission getQuizSubmissionByUserId(@PathVariable("uid") int userId,@PathVariable("qid") int quizId) {
		return service.getQuizSubmissionByUserId(userId, quizId);
	}

}
