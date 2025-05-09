package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

	List<Enrollment> findByUserId(int userId);
	List<Enrollment> findByCourseId(int courseId);

}
