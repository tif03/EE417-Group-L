package com.example.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.webapp.service.UserService;
import com.example.webapp.entity.User;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

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
    
//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User savedUser = userService.saveUser(user);
//        return ResponseEntity.ok(savedUser);
//    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        logger.info("Creating a new user with username: {}", user.getEnrollmentNumber());


        // Validate user data
        if(user.getEnrollmentNumber() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Username and password cannot be empty");
        }

        // encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        System.out.println("Received file: " + user.getEnrollmentNumber());
        // Call the service layer method to save the user.
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean isValid = userService.validateUser(user.getEnrollmentNumber(), user.getPassword());
        if (isValid) {
            // Login verification passed.
            return ResponseEntity.ok().body("User authenticated successfully");
        } else {
            // Login verification failed.
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
    
    

    // Additional endpoints for updating, deleting, etc., can be added here
}