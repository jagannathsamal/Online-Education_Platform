package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	private int courseId;
	@NotBlank(message="Title connot be empty")
	private String title;
	@NotBlank(message="Add description")
	private String description;
	@NotBlank(message="Category cannot be empty")
	private String category;
	@NotNull(message="fill the instructor id")
	private int instructorId;
	

}
