package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private int enrollmentId;
	private int userId;
	private int courseId;

}
