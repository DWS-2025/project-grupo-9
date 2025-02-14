package com.gym_admin.repositories;

import com.gym_admin.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByType(String type);
}

