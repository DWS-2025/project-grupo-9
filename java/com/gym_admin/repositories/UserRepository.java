package com.gym_admin.repositories;

import com.gym_admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to search for a user by email
    Optional<User> findByEmail(String email);
}
