package com.example.demo.dto;

import com.example.demo.model.Assignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResponseDTO {
	private Course course;
	private Assignment assignment;

}
