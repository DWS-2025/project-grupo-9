package com.gym_admin.services;

import com.gym_admin.models.Class;
import org.springframework.stereotype.Service;


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

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Optional<Class> getClassById(Long id) {
        return classRepository.findById(id);
    }

    public Class saveClass(Class classEntity) {
        return classRepository.save(classEntity);
    }

    public Class updateClass(Long id, Class updatedClass) {
        return classRepository.findById(id).map(existingClass -> {
            existingClass.setName(updatedClass.getName());
            existingClass.setDescription(updatedClass.getDescription());
            return classRepository.save(existingClass);
        }).orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    public List<Equipment> getClassEquipment(Long id) {
        return classRepository.findById(id).map(Class::getEquipment).orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }
}


