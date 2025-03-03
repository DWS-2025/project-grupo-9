package com.gym_admin.controllers;

import com.gym_admin.models.User;
import com.gym_admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUser() {
        return userService.getUser();
    }
}
