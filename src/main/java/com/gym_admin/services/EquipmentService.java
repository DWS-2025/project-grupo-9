package com.gym_admin.services;

import com.gym_admin.models.Equipment;
import com.gym_admin.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    // Listar todos los equipos
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    // Obtener un equipo por ID
    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentRepository.findById(id);
    }

    // Guardar un nuevo equipo o actualizar uno existente
    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    // Eliminar un equipo por ID
    public void deleteEquipment(Long id) {
        if (!equipmentRepository.existsById(id)) {
            throw new RuntimeException("Equipo no encontrado");
        }
        equipmentRepository.deleteById(id);
    }
}
