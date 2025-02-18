package com.gym_admin.controllers;

import com.gym_admin.models.Routine;
import com.gym_admin.services.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/routines")
public class RoutineController {
    @Autowired
    private RoutineService routineService;

    @GetMapping
    public List<Routine> getAllRoutines() {
        return routineService.getAllRoutines();
    }

    @PostMapping
    public Routine createRoutine(@RequestBody Routine routine) {
        return routineService.saveRoutine(routine);
    }

    @DeleteMapping("/{id}")
    public void deleteRoutine(@PathVariable Long id) {
        routineService.deleteRoutine(id);
    }
}