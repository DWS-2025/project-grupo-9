package com.gymadmin.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    @ManyToMany(mappedBy = "users")
    private List<ClassEntity> classes;

    // Getters y Setters
}
