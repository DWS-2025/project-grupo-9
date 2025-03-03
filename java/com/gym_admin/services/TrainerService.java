package com.gym_admin.services;

import com.gym_admin.models.Trainer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerService {

    final List<Trainer> trainers = Arrays.asList(
            new Trainer("Juan Pérez", "Entrenamiento funcional", "Especialista en fuerza y resistencia.", "/images/juan.jpg"),
            new Trainer("Ana López", "Yoga", "Profesora de yoga con más de 10 años de experiencia.", "/images/ana.jpg"),
            new Trainer("Carlos Gómez", "CrossFit", "Entrenador certificado de CrossFit con amplia experiencia.", "/images/carlos.jpg")
    );

    public List<Trainer> getAllTrainers() {
        return trainers;
    }
}

