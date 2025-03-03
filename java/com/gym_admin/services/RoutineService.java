package com.gym_admin.services;

import com.gym_admin.models.Routine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface RoutineService {

    List<Routine> routines = new ArrayList<>();

    List<Routine> getAllRoutines();

    Optional<Routine> getRoutineById(Long id);

    Optional<Routine> findByName(String name);


    Routine saveRoutine(Routine routine);

    void deleteRoutine(Long id);
}

