package com.gym_admin.models;

public class Trainer {
    private String name;
    private String specialty;
    private String description;
    private String imageUrl;

    public Trainer(String name, String specialty, String description, String imageUrl) {
        this.name = name;
        this.specialty = specialty;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
}

