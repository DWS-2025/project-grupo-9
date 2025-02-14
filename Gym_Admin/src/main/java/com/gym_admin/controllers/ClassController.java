package com.example.practicapaginaweb.controller;

import com.example.practicapaginaweb.model.Clase;
import com.example.practicapaginaweb.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @GetMapping("/clases")
    public String listClases(Model model) {
        List<Clase> clases = claseService.getAllClases();
        model.addAttribute("clases", clases);
        return "clases"; // Nombre de la plantilla Thymeleaf
    }

    @PostMapping("/clases/add")
    public String addClase(@RequestParam String nombre) {
        Clase newClase = new Clase();
        newClase.setNombre(nombre);
        claseService.saveClase(newClase);
        return "redirect:/clases";
    }

    @PostMapping("/clases/delete")
    public String deleteClase(@RequestParam Long id) {
        claseService.deleteClase(id);
        return "redirect:/clases";
    }
}