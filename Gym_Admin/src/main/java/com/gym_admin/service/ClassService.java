package com.gym_admin.services;

import com.gym_admin.models.Class;
import com.gym_admin.repositories.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Optional<Class> getClassById(Long id) {
        return classRepository.findById(id);
    }

    public Class saveClass(Class gymClass) {
        return classRepository.save(gymClass);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
