package com.gym_admin.controllers;

import com.gym_admin.models.Routine;
import com.gym_admin.services.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/routines")
public class RoutineController {

    private final RoutineService routineService;

    @Autowired
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    // Show routines page
    @GetMapping
    public String showRoutinesPage(Model model) {
        model.addAttribute("routines", routineService.getAllRoutines());
        return "routines"; // Loads routines.mustache
    }

    // Add a new routine
    @PostMapping
    public String addRoutine(@ModelAttribute Routine routine) {
        routineService.saveRoutine(routine);
        return "redirect:/routines";
    }

    // Delete a routine
    @PostMapping("/delete/{id}")
    public String deleteRoutine(@PathVariable Long id) {
        routineService.deleteRoutine(id);
        return "redirect:/routines";
    }
}


