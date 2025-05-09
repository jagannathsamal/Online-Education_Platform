package com.example.demo.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="quiz_submission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizSubmission {
	@Id
	@GeneratedValue
	private int submissionId;
	private int quizId;
	private int userId;
	@ElementCollection
	private List<String> responses;
	private int score;
	private boolean passed;
	

}
