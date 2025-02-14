package com.example.practicapaginaweb.controller;

import com.example.practicapaginaweb.model.Usuario;
import com.example.practicapaginaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/usuarios")
    public String listUsuarios(Model model) {
        List<Usuario> usuarios = userService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios"; // Nombre de la plantilla Thymeleaf
    }
}