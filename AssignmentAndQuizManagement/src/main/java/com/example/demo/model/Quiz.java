package com.example.demo.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Quiz_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
	@Id

	@Min(value = 1, message = "Quiz ID must be greater than 0")
	private int quizId;

	@Min(value = 1, message = "Course ID must be greater than 0")
	private int courseId;

	@NotEmpty(message = "Questions list cannot be empty")
	@Size(min = 1, message = "There must be at least one question")
	@ElementCollection
	private List<@NotBlank(message = "Question cannot be blank") String> questions;

	@NotEmpty(message = "Correct answers list cannot be empty")
	@Size(min = 1, message = "There must be at least one correct answer")
	@ElementCollection
	private List<@NotBlank(message = "Correct answer cannot be blank") String> correctAnswer;

	@Min(value = 1, message = "Total marks must be greater than 0")
	private int totalMarks;

}
