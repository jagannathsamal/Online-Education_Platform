package com.example.demo.dto;

import com.example.demo.model.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDTO {
	private Course course;
	private Enrollment enrollment;
	

}
