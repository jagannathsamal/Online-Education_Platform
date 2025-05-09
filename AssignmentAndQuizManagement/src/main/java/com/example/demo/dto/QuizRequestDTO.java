package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizRequestDTO {
	private int courseId;
	private String question;
	private List<String> options;
	private String correctAnswer;
	

}
