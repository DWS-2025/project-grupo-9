package com.example.practicapaginaweb.controller;

import com.example.practicapaginaweb.model.Equipamiento;
import com.example.practicapaginaweb.service.EquipamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EquipamientoController {

    @Autowired
    private EquipamientoService equipamientoService;

    @GetMapping("/equipamientos")
    public String listEquipamientos(Model model) {
        List<Equipamiento> equipamientos = equipamientoService.getAllEquipamientos();
        model.addAttribute("equipamientos", equipamientos);
        return "equipamientos"; // Nombre de la plantilla Thymeleaf
    }

    @PostMapping("/equipamientos/add")
    public String addEquipamiento(@RequestParam String nombre) {
        Equipamiento newEquipamiento = new Equipamiento();
        newEquipamiento.setNombre(nombre);
        equipamientoService.saveEquipamiento(newEquipamiento);
        return "redirect:/equipamientos";
    }

    @PostMapping("/equipamientos/delete")
    public String deleteEquipamiento(@RequestParam Long id) {
        equipamientoService.deleteEquipamiento(id);
        return "redirect:/equipamientos";
    }
}