package com.example.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.webapp.repository.UserRepository;
import com.example.webapp.entity.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
        //String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }


    // Other business logic and data access methods can be added here
}
