package com.gym_admin.controllers;

import com.gym_admin.models.Trainer;
import com.gym_admin.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    //  Show the Mustache template with trainers
    @GetMapping
    public String showTrainersPage(Model model) {
        List<Trainer> trainerList = trainerService.getAllTrainers();
        model.addAttribute("trainers", trainerList); // Pass trainers list to Mustache
        return "trainers"; // Render trainers.mustache
    }
}

