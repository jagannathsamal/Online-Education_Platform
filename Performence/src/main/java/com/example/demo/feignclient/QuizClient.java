package com.example.demo.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.QuizDTO;
import com.example.demo.dto.QuizSubmissionDTO;

@FeignClient(name = "QUIZMANAGEMENT", path = "/quiz")
public interface QuizClient {
	@GetMapping("/fetchQuizByUserId/{uid}")
	public List<CourseDTO> getCoursesByUserId(@PathVariable("uid") int userId);

	@GetMapping("/getSubmissionByUserId/{uid}/{qid}")
	public abstract QuizSubmissionDTO getQuizSubmissionByUserId(@PathVariable("uid") int userId,@PathVariable("qid") int quizId);

	@GetMapping("/getQuizByCourseId/{cid}")
	public abstract List<QuizDTO> getQuizByCourseId(@PathVariable("cid") int courseId);

}
