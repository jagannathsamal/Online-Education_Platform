package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="enroll_details")
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
	@Id
	@GeneratedValue
	@Min(value = 1, message = "Enrollment ID must be greater than 0")
	private int enrollmentId;

	@Min(value = 1, message = "User ID must be greater than 0")
	private int userId;

	@Min(value = 1, message = "Course ID must be greater than 0")
	private int courseId;


}
