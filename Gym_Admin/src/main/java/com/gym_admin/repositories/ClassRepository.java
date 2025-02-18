package com.gym_admin.repositories;

import com.gym_admin.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    // Método personalizado para buscar clases por nombre
    List<Class> findByName(String name);
}

