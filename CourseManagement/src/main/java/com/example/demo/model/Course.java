package com.example.demo.model;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
	@GeneratedValue
	private int courseId;
	@NotBlank(message="Title connot be empty")
	private String title;
	@NotBlank(message="Add description")
	private String description;
	@NotBlank(message="Category cannot be empty")
	private String category;
	@NotBlank(message="Name cannot be empty")
	private String instructorName;
	@NotBlank(message = "link cannot be empty")
	@URL(message = "Invalid URL format")
	private String content;

	

}
