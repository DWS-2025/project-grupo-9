package com.gym_admin.services;

import com.gym_admin.models.TrainingClass;
import com.gym_admin.repositories.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClassServiceimpl implements ClassService {

    private ClassRepository classRepository;

    public ClassServiceimpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<TrainingClass> getAllClasses() {
        return this.classRepository.findAll();
    }

    @Override
    public Optional<TrainingClass> getClassById(Long id) {
        return this.classRepository.findById(id);
    }

    @Override
    public TrainingClass saveClass(TrainingClass classEntity) {
        return this.classRepository.save(classEntity);
    }

    @Override
    public TrainingClass updateClass(Long id, TrainingClass updatedClass) {
        return this.classRepository.save(updatedClass);
    }

    @Override
    public void deleteClass(Long id) {
        this.classRepository.deleteById(id);
    }

}
