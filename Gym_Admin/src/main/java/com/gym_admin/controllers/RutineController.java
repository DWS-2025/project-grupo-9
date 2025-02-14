package com.example.practicapaginaweb.controller;

import com.example.practicapaginaweb.model.Rutina;
import com.example.practicapaginaweb.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping("/rutinas")
    public String listRutinas(Model model) {
        List<Rutina> rutinas = rutinaService.getAllRutinas();
        model.addAttribute("rutinas", rutinas);
        return "rutinas"; // Nombre de la plantilla Thymeleaf
    }

    @PostMapping("/rutinas/add")
    public String addRutina(@RequestParam String nombre) {
        Rutina newRutina = new Rutina();
        newRutina.setNombre(nombre);
        rutinaService.saveRutina(newRutina);
        return "redirect:/rutinas";
    }

    @PostMapping("/rutinas/delete")
    public String deleteRutina(@RequestParam Long id) {
        rutinaService.deleteRutina(id);
        return "redirect:/rutinas";
    }
}