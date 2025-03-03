package com.gym_admin.repositories;

import com.gym_admin.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    // Custom method to search for equipment by status
    List<Equipment> findByStatus(String status);
}

