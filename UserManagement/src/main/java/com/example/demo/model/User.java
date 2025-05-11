package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	@Min(value = 1, message = "User ID must be greater than 0")
	private int userId;

	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")

	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	@Size(max = 50, message = "Email must not exceed 50 characters")

	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,20}$",message = "Password must contain at least one digit, one lowercase, one uppercase, and one special character")

	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;

}


