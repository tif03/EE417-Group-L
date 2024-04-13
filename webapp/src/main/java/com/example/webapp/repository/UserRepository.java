package com.example.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.webapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// Method to find a user by their enrollment number
    Optional<User> findByEnrollmentNumber(String enrollmentNumber);

    // Method to find a user by their email address
    Optional<User> findByEmail(String email);
}
