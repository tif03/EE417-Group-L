package com.example.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.webapp.repository.UserRepository;
import com.example.webapp.entity.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Find user by enrollment number
    @Transactional(readOnly = true)
    public Optional<User> findByEnrollmentNumber(String enrollmentNumber) {
        return userRepository.findByEnrollmentNumber(enrollmentNumber);
    }

    // Find user by email
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Add a new user
    @Transactional
    public User saveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    // Validate a user by enrollment number and password
    public boolean validateUser(String enrollmentNumber, String rawPassword) {
        Optional<User> optionalUser = userRepository.findByEnrollmentNumber(enrollmentNumber);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false;
    }

    // Other business logic and data access methods can be added here
}
