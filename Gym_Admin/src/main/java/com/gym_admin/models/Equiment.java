package com.gymadmin.models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String status;

    // Getters y Setters
}
