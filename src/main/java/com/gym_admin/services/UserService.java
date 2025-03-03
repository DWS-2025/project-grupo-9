package com.gym_admin.services;

import com.gym_admin.models.User;
import com.gym_admin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Inyecta el UserRepository

    private final Map<String, User> users = new HashMap<>();

    public UserService() {
        // Crear un usuario administrador por defecto
        User admin = new User();
        admin.setId(1L);
        admin.setName("Admin");
        admin.setEmail("admin@gym.com");
        admin.setPassword("admin");
        admin.setRole("ADMIN");
        users.put(admin.getEmail(), admin);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email); // Usa el repositorio para buscar por correo electrónico
    }

    public User registerUser(User user) {
        return userRepository.save(user); // Usa el repositorio para guardar el nuevo usuario
    }

    public User getCurrentUser() { // Método para obtener el usuario actual (admin por defecto)
        return users.values().iterator().next();
    }
}
