package com.gym_admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Renderiza templates/login.mustache
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Aquí iría la lógica de autenticación
        // Por ahora, simplemente redirigimos al menú
        model.addAttribute("username", username);
        return "menu"; // Renderiza templates/menu.mustache
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Renderiza templates/register.mustache
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        // Aquí iría la lógica para registrar un nuevo usuario
        model.addAttribute("message", "Registration successful. Please login.");
        return "login"; // Renderiza templates/login.mustache
    }

    @GetMapping("/menu")
    public String menuPage(Model model) {
        // Aquí iría la lógica para obtener el nombre de usuario del usuario autenticado
        model.addAttribute("username", "User"); // Reemplaza con el nombre de usuario real
        return "menu"; // Renderiza templates/menu.mustache
    }

    @GetMapping("/logout")
    public String logoutPage() {
        // Aquí iría la lógica para cerrar la sesión del usuario
        return "redirect:/login"; // Redirige a /login
    }
}
