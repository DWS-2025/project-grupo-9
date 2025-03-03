package com.gym_admin.controllers;

import com.gym_admin.models.TrainingClass;
import com.gym_admin.services.ClassService;
import com.gym_admin.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;
    private final EquipmentService equipmentService;

    @Autowired
    public ClassController(ClassService classService, EquipmentService equipmentService) {
        this.classService = classService;
        this.equipmentService = equipmentService;
    }

    // Display class management page
    @GetMapping("/manage")
    public String showManageClasses(Model model) {
        model.addAttribute("classes", classService.getAllClasses());
        model.addAttribute("equipments", equipmentService.getAllEquipment());
        return "manage_class"; // Loads manage_class.mustache
    }

    // Get all classes in JSON format
    @GetMapping("/api")
    @ResponseBody
    public List<TrainingClass> getAllClasses() {
        return classService.getAllClasses();
    }

    // Get a class by ID
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<TrainingClass> getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    // Create a new class
    @PostMapping
    public String createClass(@ModelAttribute TrainingClass classEntity) {
        classService.saveClass(classEntity);
        return "redirect:/classes/manage";
    }

    // Update an existing class
    @PutMapping("/{id}")
    public String updateClass(@PathVariable Long id, @ModelAttribute TrainingClass classEntity) {
        classService.updateClass(id, classEntity);
        return "redirect:/classes/manage";
    }

    // Delete a class
    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return "redirect:/classes/manage";
    }
}
