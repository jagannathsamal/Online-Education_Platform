package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="user_details")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private int userId;
	private String name;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;

}


