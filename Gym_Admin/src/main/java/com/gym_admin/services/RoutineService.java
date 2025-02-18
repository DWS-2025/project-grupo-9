package com.gym_admin.services;

import com.gym_admin.models.Routine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoutineService {

    private final List<Routine> routines = new ArrayList<>();

    public List<Routine> getAllRoutines() {
        return routines;
    }

    public Optional<Routine> getRoutineById(Long id) {
        return routines.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public Routine saveRoutine(Routine routine) {
        routines.add(routine);
        return routine;
    }

    public void deleteRoutine(Long id) {
        routines.removeIf(r -> r.getId().equals(id));
    }
}

