package com.gym_admin.services;

import com.gym_admin.models.User;
import com.gym_admin.repositories.ClassRepository;
import com.gym_admin.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;

    private final User defaultUser;

    public UserService() {
        this.defaultUser = new User();
        this.defaultUser.setId(1L);
        this.defaultUser.setName("Admin");
        this.defaultUser.setEmail("admin@gym.com");
        this.defaultUser.setPassword("1234");
        this.defaultUser.setRole("ADMIN");
    }

    public Optional<User> getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUser() {
        return defaultUser;
    }
}
