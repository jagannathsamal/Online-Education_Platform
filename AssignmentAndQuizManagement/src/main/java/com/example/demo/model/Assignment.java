package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Assignment_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
	@Id
	@GeneratedValue
	private int assignmentId;
	private int courseId;
	private String title;
	private LocalDate dueDate;
	

}
