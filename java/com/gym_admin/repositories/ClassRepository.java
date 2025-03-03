package com.gym_admin.repositories;

import com.gym_admin.models.TrainingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<TrainingClass, Long> {

}


