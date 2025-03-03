package com.gym_admin.services;

import com.gym_admin.models.Routine;
import com.gym_admin.repositories.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    // Listar todas las rutinas
    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }

    // Obtener una rutina por ID
    public Optional<Routine> getRoutineById(Long id) {
        return routineRepository.findById(id);
    }

    // Guardar una nueva rutina o actualizar una existente
    public Routine saveRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    // Eliminar una rutina por ID
    public void deleteRoutine(Long id) {
        if (!routineRepository.existsById(id)) {
            throw new RuntimeException("Rutina no encontrada");
        }
        routineRepository.deleteById(id);
    }
}
