package com.gym_admin.services;

import com.gym_admin.models.Routine;
import com.gym_admin.repositories.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoutineServiceimpl implements RoutineService {

    private RoutineRepository routineRepository;

    @Override
    public List<Routine> getAllRoutines() {
        return this.routineRepository.findAll();
    }

    @Override
    public Optional<Routine> getRoutineById(Long id) {
        return this.routineRepository.findById(id);
    }

    @Override
    public Optional<Routine> findByName(String name) {
        return this.routineRepository.findByName(name);
    }

    @Override
    public Routine saveRoutine(Routine routine) {
        return this.routineRepository.save(routine);
    }

    @Override
    public void deleteRoutine(Long id) {
        this.routineRepository.deleteById(id);
    }
}
