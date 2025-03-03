package com.gym_admin.services;

import com.gym_admin.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final User defaultUser;

    public UserService() {
        this.defaultUser = new User();
        this.defaultUser.setId(1L);
        this.defaultUser.setName("Admin");
        this.defaultUser.setEmail("admin@gym.com");
        this.defaultUser.setPassword("1234");
        this.defaultUser.setRole("ADMIN");
    }

    public User getUser() {
        return defaultUser;
    }
}
