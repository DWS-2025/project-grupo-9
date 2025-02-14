package com.gym_admin.repositories;

import com.gym_admin.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findByName(String name);
}


