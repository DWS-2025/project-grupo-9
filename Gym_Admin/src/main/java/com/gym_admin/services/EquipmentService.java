package com.gym_admin.services;

import com.gym_admin.models.Equipment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private final List<Equipment> equipmentList = new ArrayList<>();

    public List<Equipment> getAllEquipment() {
        return equipmentList;
    }

    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentList.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Equipment saveEquipment(Equipment equipment) {
        equipmentList.add(equipment);
        return equipment;
    }

    public void deleteEquipment(Long id) {
        equipmentList.removeIf(e -> e.getId().equals(id));
    }
}

