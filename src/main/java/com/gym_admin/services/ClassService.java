package com.gym_admin.services;

import com.gym_admin.models.Class;
import com.gym_admin.models.Equipment;
import com.gym_admin.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    // Listar todas las clases
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    // Obtener una clase por ID
    public Optional<Class> getClassById(Long id) {
        return classRepository.findById(id);
    }

    // Guardar una nueva clase o actualizar una existente
    public Class saveClass(Class gymClass) {
        return classRepository.save(gymClass);
    }

    // Actualizar una clase existente
    public Class updateClass(Long id, Class updatedClass) {
        return classRepository.findById(id).map(existingClass -> {
            existingClass.setName(updatedClass.getName());
            existingClass.setDescription(updatedClass.getDescription());
            existingClass.setInstructor(updatedClass.getInstructor());
            existingClass.setSchedule(updatedClass.getSchedule());
            existingClass.setEquipmentList(updatedClass.getEquipmentList()); // Actualizar equipos asociados
            return classRepository.save(existingClass);
        }).orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    // Eliminar una clase por ID
    public void deleteClass(Long id) {
        if (!classRepository.existsById(id)) {
            throw new RuntimeException("Clase no encontrada");
        }
        classRepository.deleteById(id);
    }
}
