package com.example.demo.service;

import com.example.demo.dto.AssignmentRequestDTO;
import com.example.demo.dto.AssignmentResponseDTO;
import com.example.demo.model.Assignment;

public interface AssignmentService {

	public abstract String saveAssignment(AssignmentRequestDTO request);
	
	public abstract String deleteAssignment(int assignmentId);
	
	public abstract AssignmentResponseDTO getAssignmentById(int assignmentId);

}
