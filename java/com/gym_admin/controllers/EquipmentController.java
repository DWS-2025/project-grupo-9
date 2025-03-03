package com.gym_admin.controllers;

import com.gym_admin.models.Equipment;
import com.gym_admin.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    // Show equipment page
    @GetMapping
    public String showEquipmentPage(Model model) {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        model.addAttribute("equipments", equipmentList);
        return "equipment"; // Loads equipment.mustache
    }

    // Handle equipment creation
    @PostMapping
    public String createEquipment(@ModelAttribute Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipment";
    }

    // Handle equipment deletion
    @PostMapping("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return "redirect:/equipment";
    }
}

