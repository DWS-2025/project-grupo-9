package com.gym_admin.controllers;

import com.gym_admin.models.Routine;
import com.gym_admin.services.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/routines")
public class RoutineController {

    private final RoutineService routineService;

    @Autowired
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    // Listar todas las rutinas
    @GetMapping
    public String listRoutines(Model model) {
        model.addAttribute("routines", routineService.getAllRoutines());
        return "routine-list"; // Renderiza templates/routine-list.mustache
    }

    // Mostrar formulario para crear/editar una rutina
    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("routine", routineService.getRoutineById(id).orElse(new Routine()));
        } else {
            model.addAttribute("routine", new Routine());
        }
        return "routine-form"; // Renderiza templates/routine-form.mustache
    }

    // Guardar una nueva rutina o actualizar una existente
    @PostMapping
    public String saveRoutine(@ModelAttribute("routine") Routine routine) {
        routineService.saveRoutine(routine);
        return "redirect:/routines";
    }

    // Eliminar una rutina por ID
    @GetMapping("/delete/{id}")
    public String deleteRoutine(@PathVariable Long id) {
        routineService.deleteRoutine(id);
        return "redirect:/routines";
    }
}
