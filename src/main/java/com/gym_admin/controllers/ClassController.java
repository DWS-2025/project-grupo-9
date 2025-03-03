package com.gym_admin.controllers;

import com.gym_admin.models.Class;
import com.gym_admin.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    // Listar todas las clases
    @GetMapping
    public String listClasses(Model model) {
        model.addAttribute("classes", classService.getAllClasses());
        return "class-list"; // Renderiza templates/class-list.mustache
    }

    // Mostrar formulario para crear/editar una clase
    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("gymClass", classService.getClassById(id).orElse(new Class()));
        } else {
            model.addAttribute("gymClass", new Class());
        }
        return "class-form"; // Renderiza templates/class-form.mustache
    }

    // Guardar una nueva clase o actualizar una existente
    @PostMapping
    public String saveClass(@ModelAttribute("gymClass") Class gymClass) {
        classService.saveClass(gymClass);
        return "redirect:/classes";
    }

    // Eliminar una clase por ID
    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return "redirect:/classes";
    }
}


