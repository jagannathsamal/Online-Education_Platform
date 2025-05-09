package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;
	@PostMapping("/save")
	public String createUser(@RequestBody User user) {
		service.createUser(user);
		return "User created successfully";
	}
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
		
	}

	@GetMapping("/findById/{id}")
	public User getUser(@PathVariable("id") int userId) throws UserNotFound {
		return service.getUser(userId);
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser() {
		return service.getAllUser();
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteUser(@PathVariable("id") int userId) {
		return service.deleteUser(userId);
	}

	@GetMapping("/findByMail/{mail}")
	public User getByEmail(@PathVariable("mail") String email) {
		return service.getByEmail(email);
	}
	@GetMapping("/existsById/{id}")
	public boolean existsById(@PathVariable("id") int userId) {
		return service.existsById(userId);
	}

}
