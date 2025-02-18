package com.gym_admin.services;

import com.gym_admin.models.Class;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    private final List<Class> classes = new ArrayList<>();

    public List<Class> getAllClasses() {
        return classes;
    }

    public Optional<Class> getClassById(Long id) {
        return classes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Class saveClass(Class classEntity) {
        classes.add(classEntity);
        return classEntity;
    }

    public void deleteClass(Long id) {
        classes.removeIf(c -> c.getId().equals(id));
    }
}

