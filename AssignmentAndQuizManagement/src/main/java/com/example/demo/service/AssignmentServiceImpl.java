package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AssignmentRequestDTO;
import com.example.demo.dto.AssignmentResponseDTO;
import com.example.demo.dto.Course;
import com.example.demo.feignclient.CourseClient;
import com.example.demo.model.Assignment;
import com.example.demo.repository.AssignmentRepository;
@Service
public class AssignmentServiceImpl implements AssignmentService {
	
	@Autowired
	AssignmentRepository repository;
	
	@Autowired
	CourseClient courseClient;

	@Override
	public String saveAssignment(AssignmentRequestDTO request) {
		
		if (courseClient.getcourse(request.getCourseId()) != null) {
            Assignment assignment = new Assignment();
            assignment.setCourseId(request.getCourseId());
            assignment.setTitle(request.getTitle());
            assignment.setDueDate(request.getDueDate());
            repository.save(assignment);
            return "Assignment created successfully.";
        }else {
        	return "Invalid course Id........";
        	
        }
    }

	@Override
	public String deleteAssignment(int assignmentId) {
		repository.deleteById(assignmentId);
		return "Assignment deleted successfully......";
	}

	@Override
	public AssignmentResponseDTO getAssignmentById(int assignmentId) {
		Assignment assignment=repository.findById(assignmentId).get();
		int courseId=assignment.getAssignmentId();
		Course course= courseClient.getcourse(courseId);
		AssignmentResponseDTO responseDTO=new AssignmentResponseDTO(course,assignment);
		return responseDTO;
	}

	}

	
