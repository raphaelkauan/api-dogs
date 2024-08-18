package com.api.repository;

import com.api.entities.DogEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.UUID;

public interface DogReposity extends JpaRepository<DogEntity, UUID> {
}
