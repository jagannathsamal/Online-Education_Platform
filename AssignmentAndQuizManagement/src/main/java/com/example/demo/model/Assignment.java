package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Assignment_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
	@Id
	@GeneratedValue

	@Min(value = 1, message = "Assignment ID must be greater than 0")
	private int assignmentId;

	@Min(value = 1, message = "Course ID must be greater than 0")
	private int courseId;

	@NotBlank(message = "Title is required")
	@Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
	private String title;

	@NotNull(message = "Due date is required")
	@FutureOrPresent(message = "Due date must be today or in the future")
	private LocalDate dueDate;

}
