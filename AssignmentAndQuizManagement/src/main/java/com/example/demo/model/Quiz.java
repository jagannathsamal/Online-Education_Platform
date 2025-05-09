package com.example.demo.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Quiz_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
	@Id
	private int quizId;
	private int courseId;
	@ElementCollection
	private List<String> questions;
	@ElementCollection
	private List<String> options;
	@ElementCollection
	private List<String> correctAnswer;
	private int totalMarks;
	

}
