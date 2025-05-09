package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public String createUser(User user) {

		user.setPassword(passwordEncoder(user.getPassword()));
		repository.save(user);
		return "User created successfully";
	}

	@Override
	public User updateUser(User user) {
		return repository.save(user);
		
	}


	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public String deleteUser(int userId) {
		repository.deleteById(userId);
		return "User deleted successfully...";
	}

	@Override
	public User getByEmail(String email) {
		return repository.findByEmail(email);
	}
	private String passwordEncoder(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

	@Override
	public boolean existsById(int userId) {
		return repository.existsById(userId);
	}

	@Override
	public User getUser(int userId) throws UserNotFound {
		Optional<User> optional=repository.findById(userId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new UserNotFound("User Not found");
	}

}
