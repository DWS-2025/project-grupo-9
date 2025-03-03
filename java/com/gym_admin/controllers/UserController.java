package com.gym_admin.controllers;

import com.gym_admin.models.User;
import com.gym_admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Get a single user (change logic as needed)
    @GetMapping("/users")
    @ResponseBody
    public User getUser() {
        return userService.getUser();
    }

    // Get user by email
    @GetMapping("/users/{email}")
    @ResponseBody
    public ResponseEntity<Optional<User>> UserEmail(@PathVariable String email) {
        Optional<User> user = this.userService.getUserByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
