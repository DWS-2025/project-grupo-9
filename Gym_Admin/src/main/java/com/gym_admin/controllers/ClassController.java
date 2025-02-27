package com.gym_admin.controllers;

import com.gym_admin.models.Class;
import com.gym_admin.models.Equipment;
import com.gym_admin.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    // Obtener todas las clases
    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    // Obtener una clase por ID
    @GetMapping("/{id}")
    public Optional<Class> getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    // Crear una nueva clase
    @PostMapping
    public Class createClass(@RequestBody Class classEntity) {
        return classService.saveClass(classEntity);
    }

    // Actualizar una clase
    @PutMapping("/{id}")
    public Class updateClass(@PathVariable Long id, @RequestBody Class classEntity) {
        return classService.updateClass(id, classEntity);
    }

    // Eliminar una clase
    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }

    // Obtener el equipamiento asociado a una clase
    @GetMapping("/{id}/equipment")
    public List<Equipment> getClassEquipment(@PathVariable Long id) {
        return classService.getClassEquipment(id);
    }
}



