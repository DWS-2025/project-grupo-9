package com.gym_admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //  Render the Mustache home template with dynamic data
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Welcome to EnergyFit Gym"); // Example of dynamic data
        return "home"; // Loads home.mustache from templates/
    }
}
