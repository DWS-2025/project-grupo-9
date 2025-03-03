package com.gym_admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //  Render the Mustache login template dynamically
    @GetMapping("/")
    public String showLoginPage() {
        return "index";  // Loads index.mustache from templates/
    }
}



