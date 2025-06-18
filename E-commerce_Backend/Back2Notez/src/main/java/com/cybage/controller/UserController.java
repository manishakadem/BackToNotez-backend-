package com.cybage.controller;

import com.cybage.bean.UserBean;
import com.cybage.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    //Register user
    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserBean userBean, BindingResult result) {
    	if(result.hasErrors()) {
    		List<String> errors = result.getAllErrors()
    				.stream()
    				.map(ObjectError::getDefaultMessage)
    				.toList();
    		return ResponseEntity.badRequest().body(errors);
    	}
    	String response = userService.registerUser(userBean);
    	return ResponseEntity.ok(response);
    }
    
    //login user
    @PostMapping("/login-user")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
    	boolean success = userService.loginUser(credentials.get("email"), credentials.get("password"));
    	if (success) {
    		return ResponseEntity.ok("Login Success");
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    	}
    }

    // Get all users
    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserBean>> getAllUsers() {
        List<UserBean> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get user by ID
    @GetMapping("/get-user/{userId}")
    public ResponseEntity<UserBean> getUserById(@PathVariable("userId") int userId) {
        UserBean user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update user
    @PutMapping("/update-user/{userId}")
    public ResponseEntity<UserBean> updateUser(@PathVariable("userId") int userId, @RequestBody UserBean userBean) {
        userBean.setUserId(userId);
        UserBean updatedUser = userService.updateUser(userBean);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user
    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
        boolean deleted = userService.deleteUser(userId);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
