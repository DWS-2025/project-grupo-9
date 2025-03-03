package com.gym_admin.services;

import com.gym_admin.models.TrainingClass;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface ClassService {

    List<TrainingClass> getAllClasses();

    Optional<TrainingClass> getClassById(Long id);

    TrainingClass saveClass(TrainingClass classEntity);

    TrainingClass updateClass(Long id, TrainingClass updatedClass);

    void deleteClass(Long id);
}


