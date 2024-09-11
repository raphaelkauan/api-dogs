package com.api.service;

import com.api.dtos.DogDto;
import com.api.entities.DogEntity;
import com.api.repository.DogReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DogService {

    @Autowired
    private DogReposity dogReposity;

    public ResponseEntity<?> create(DogDto dogDto) {

        DogEntity dog = new DogEntity();
        dog.setNome(dogDto.nome());
        dog.setRaca(dogDto.raca());
        dog.setIdade(dogDto.idade());

        dogReposity.save(dog);

        return ResponseEntity.status(HttpStatus.CREATED).body("Dog cadastrado com sucesso!");
    }

    public ResponseEntity<?> getAll() {
        List<DogEntity> dogEntity = dogReposity.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(dogEntity);
    }

    public ResponseEntity<?> update(UUID id, DogDto dogDto) {
        System.out.println("ID SERVICE: " + id);
        System.out.println("DTO SERVICE: " + dogDto);
        Optional<DogEntity> dog = dogReposity.findById(id);

        if(dog.isEmpty()) {
            throw new RuntimeException();
        }

        DogEntity dogEntity = dog.get();
        dogEntity.setNome(dogDto.nome());
        dogEntity.setRaca(dogDto.raca());
        dogEntity.setIdade(dogDto.idade());

        dogReposity.save(dogEntity);

        return ResponseEntity.status(HttpStatus.OK).body("Dog atualizado!");
    }

    public ResponseEntity<?> delete(UUID id) {
        Optional<DogEntity> dog = dogReposity.findById(id);

        if(dog.isEmpty()) {
            throw new RuntimeException();
        }

        dogReposity.delete(dog.get());

        return ResponseEntity.status(HttpStatus.OK).body("dog deletado!");
    }
}
