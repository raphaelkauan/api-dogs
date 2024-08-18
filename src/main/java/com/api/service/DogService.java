package com.api.service;

import com.api.dtos.DogDto;
import com.api.entities.DogEntity;
import com.api.repository.DogReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
