package com.gym_admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/login") // Changed from "/" to "/login" to avoid redirect loop
    public String showLoginPage() {
        return "index";  // Loads index.mustache from templates/
    }
}




