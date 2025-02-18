package com.gym_admin.controllers;

import com.gym_admin.models.Equipment;
import com.gym_admin.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @PostMapping
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentService.saveEquipment(equipment);
    }

    @PostMapping("/{id}/upload-image")
    public String uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        String filePath = "uploads/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return "Imagen subida correctamente: " + filePath;
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }
}
