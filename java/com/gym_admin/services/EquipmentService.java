package com.gym_admin.services;

import com.gym_admin.models.Equipment;
import com.gym_admin.models.TrainingClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface EquipmentService {

    List<Equipment> getAllEquipment();

    List<Equipment> findByClassEntity(TrainingClass classEntity);

    List<Equipment> findByStatus(String status);

    Optional<Equipment> getEquipmentById(Long id);

    Equipment saveEquipment(Equipment equipment);

    void deleteEquipment(Long id);
}

