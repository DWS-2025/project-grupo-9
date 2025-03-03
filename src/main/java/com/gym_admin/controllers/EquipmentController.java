package com.gym_admin.controllers;

import com.gym_admin.models.Equipment;
import com.gym_admin.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    // Listar todos los equipos
    @GetMapping
    public String listEquipment(Model model) {
        model.addAttribute("equipmentList", equipmentService.getAllEquipment());
        return "equipment-list"; // Renderiza templates/equipment-list.mustache
    }

    // Mostrar formulario para crear/editar un equipo
    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("equipment", equipmentService.getEquipmentById(id).orElse(new Equipment()));
        } else {
            model.addAttribute("equipment", new Equipment());
        }
        return "equipment-form"; // Renderiza templates/equipment-form.mustache
    }

    // Guardar un nuevo equipo o actualizar uno existente
    @PostMapping
    public String saveEquipment(@ModelAttribute("equipment") Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipment";
    }

    // Eliminar un equipo por ID
    @GetMapping("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return "redirect:/equipment";
    }
}

