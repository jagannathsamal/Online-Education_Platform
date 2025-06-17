package com.example.demo.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quiz_submission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizSubmission {
	@Id

	@GeneratedValue
	@Min(value = 1, message = "Submission ID must be greater than 0")
	private int submissionId;

	@Min(value = 1, message = "Quiz ID must be greater than 0")
	private int quizId;

	@Min(value = 1, message = "Course ID must be greater than 0")
	private int courseId;

	@Min(value = 1, message = "User ID must be greater than 0")
	private int userId;

	@ElementCollection
	private List<String> responses;

	@Min(value = 0, message = "Score cannot be negative")
	private int score;

	// No validation needed for boolean
	private boolean passed;

}
