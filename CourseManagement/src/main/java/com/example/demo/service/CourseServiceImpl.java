package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CourseNotFound;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository repository;

	@Override
	public String saveCourse(Course course) {
		repository.save(course);
		return "course saved successfully.....";
	}

	@Override
	public Course updateCouse(Course course) {
		return repository.save(course);
		
	}

	@Override
	public Course getcourse(int courseId) throws CourseNotFound {
		Optional<Course> optional=repository.findById(courseId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new CourseNotFound("invalid course Id");
		}
	}

	@Override
	public List<Course> getAllCourse() {
		return repository.findAll();
	}

	@Override
	public String deleteCourse(int courseId) {
		repository.deleteById(courseId);
		return "course deleted successfully......";
	}

	@Override
	public boolean existsById(int courseId) {
		return repository.existsById(courseId);
	}

	@Override
	public String getContentByCourseId(int courseId) {
		Course course = repository.findContentByCourseId(courseId);
		return course.getContent();
	}


}
