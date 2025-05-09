package com.example.demo.dto;

import com.example.demo.model.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponseDTO {
	private Course course;
	private Quiz quiz;
	

}
