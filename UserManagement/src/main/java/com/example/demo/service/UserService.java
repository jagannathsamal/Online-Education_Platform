package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;

public interface UserService {
	public abstract String  createUser(User user);
	
	
	public abstract User  updateUser(User user);
	
	public abstract User getUser(int userId) throws UserNotFound;
	
	public abstract List<User> getAllUser();
	
	public abstract String  deleteUser(int userId);
	
	public abstract User getByEmail(String email);
	
	public abstract boolean existsById(int userId);
	

}
