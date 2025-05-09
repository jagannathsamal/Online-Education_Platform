package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	List<Quiz> findByCourseId(int courseId);

}
