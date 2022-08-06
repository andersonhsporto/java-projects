package com.api.jparelationships.controllers;

import com.api.jparelationships.entities.FamilyEntity;
import com.api.jparelationships.entities.SpeciesEntity;
import com.api.jparelationships.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    SpeciesRepository speciesRepository;

    @PostMapping
    public ResponseEntity createSpecies(@RequestBody Map<String, Object> requestMap) {
        SpeciesEntity species = new SpeciesEntity();
        species.setName((String) requestMap.get("name"));
        species.setGenus((String) requestMap.get("genus"));
        speciesRepository.save(species);
        return ResponseEntity.status(HttpStatus.OK).body("Species created successfully");
    }

}
