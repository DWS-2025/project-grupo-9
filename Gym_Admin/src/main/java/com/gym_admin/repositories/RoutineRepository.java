package com.gym_admin.repositories;

import com.gym_admin.models.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    // Método personalizado para buscar una rutina por nombre
    Routine findByName(String name);
}
