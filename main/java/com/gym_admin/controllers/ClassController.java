package com.gym_admin.controllers;

import com.gym_admin.models.Class;
import com.gym_admin.models.Equipment;
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

    //  Display the Mustache template with dynamic data
    @GetMapping("/manage")
    public String showManageClasses(Model model) {
        model.addAttribute("classes", classService.getAllClasses()); // Pass all classes
        model.addAttribute("equipments", equipmentService.getAllEquipment()); // Pass all equipment
        return "manage_class"; // Load manage_class.mustache
    }

    //  Get all classes in JSON format (useful for APIs if needed)
    @GetMapping
    @ResponseBody
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    //  Get a class by ID
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Class> getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    //  Create a new class
    @PostMapping
    public String createClass(@ModelAttribute Class classEntity) {
        classService.saveClass(classEntity);
        return "redirect:/classes/manage"; // Redirect to Mustache view after creation
    }

    //  Update an existing class
    @PutMapping("/{id}")
    public String updateClass(@PathVariable Long id, @ModelAttribute Class classEntity) {
        classService.updateClass(id, classEntity);
        return "redirect:/classes/manage"; // Redirect after update
    }

    //  Delete a class
    @DeleteMapping("/{id}")
    public String deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return "redirect:/classes/manage"; // Redirect after deletion
    }

    //  Get the equipment associated with a class
    @GetMapping("/{id}/equipment")
    @ResponseBody
    public List<Equipment> getClassEquipment(@PathVariable Long id) {
        return classService.getClassEquipment(id);
    }
}
