package com.gym_admin.services;

import com.gym_admin.models.Equipment;
import com.gym_admin.models.TrainingClass;
import com.gym_admin.repositories.ClassRepository;
import com.gym_admin.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EquipmentServiceimpl implements EquipmentService {

    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAllEquipment() {
        return this.equipmentRepository.findAll();
    }

    @Override
    public List<Equipment> findByClassEntity(TrainingClass classEntity) {
        return this.equipmentRepository.findByClassEntity(classEntity);
    }

    @Override
    public List<Equipment> findByStatus(String status) {
        return this.equipmentRepository.findByStatus(status);
    }

    @Override
    public Optional<Equipment> getEquipmentById(Long id) {
        return this.equipmentRepository.findById(id);
    }

    @Override
    public Equipment saveEquipment(Equipment equipment) {
        return this.equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(Long id) {
        this.equipmentRepository.deleteById(id);
    }
}
