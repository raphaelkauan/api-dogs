package com.api.controllers;

import com.api.service.DogService;
import com.api.dtos.DogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody DogDto dogDto) {
        return this.dogService.create(dogDto);
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return this.dogService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody DogDto dogDto) {
        System.out.println("ID:" + id);

        return this.dogService.update(id, dogDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        return this.dogService.delete(id);
    }
}
