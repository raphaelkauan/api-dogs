package com.api.controllers;

import com.api.service.DogService;
import com.api.dtos.DogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/dog")
    public ResponseEntity<?> create(@RequestBody DogDto dogDto) {
        return this.dogService.create(dogDto);
    }

    @GetMapping("/dogs")
    public ResponseEntity<?> getAll() {
        return this.dogService.getAll();
    }
}
