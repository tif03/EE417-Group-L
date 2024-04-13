package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.webapp.service.UserService;
import com.example.webapp.entity.User;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get user by enrollment number
    @GetMapping("/enrollment/{enrollmentNumber}")
    public ResponseEntity<User> getUserByEnrollmentNumber(@PathVariable String enrollmentNumber) {
        Optional<User> user = userService.findByEnrollmentNumber(enrollmentNumber);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new user
    
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
    
    

    // Additional endpoints for updating, deleting, etc., can be added here
}