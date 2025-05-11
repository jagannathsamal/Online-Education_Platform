package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.controller.UserController;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

class UserManagementApplicationTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(1, "John Doe", "john@example.com", "Password@123", Role.Student);
    }

    @Test
    void testCreateUser() {
        when(userService.createUser(user)).thenReturn("User created successfully");
        String result = userController.createUser(user);
        assertEquals("User created successfully", result);
    }

    @Test
    void testUpdateUser() {
        when(userService.updateUser(user)).thenReturn(user);
        User updated = userController.updateUser(user);
        assertEquals(user, updated);
    }

    @Test
    void testGetUserById() throws UserNotFound {
        when(userService.getUser(1)).thenReturn(user);
        User result = userController.getUser(1);
        assertEquals(user, result);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getAllUser()).thenReturn(users);
        List<User> result = userController.getAllUser();
        assertEquals(1, result.size());
    }

    @Test
    void testDeleteUser() {
        when(userService.deleteUser(1)).thenReturn("User deleted successfully...");
        String result = userController.deleteUser(1);
        assertEquals("User deleted successfully...", result);
    }

    @Test
    void testGetByEmail() {
        when(userService.getByEmail("john@example.com")).thenReturn(user);
        User result = userController.getByEmail("john@example.com");
        assertEquals(user, result);
    }

    @Test
    void testExistsById() {
        when(userService.existsById(1)).thenReturn(true);
        boolean exists = userController.existsById(1);
        assertTrue(exists);
    }
}

