package com.gym_admin.repositories;

import com.gym_admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to search for a user by email
    User findByEmail(String email);
}
