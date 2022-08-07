package com.api.jparelationships.controllers;

import com.api.jparelationships.entities.FamilyEntity;
import com.api.jparelationships.entities.RegionEntity;
import com.api.jparelationships.entities.SpeciesEntity;
import com.api.jparelationships.repository.FamilyRepository;
import com.api.jparelationships.repository.RegionRepository;
import com.api.jparelationships.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    FamilyRepository familyRepository;

    @GetMapping
    List<SpeciesEntity> getAllSpecies() {
        return speciesRepository.findAll();
    }

    @PostMapping
    public ResponseEntity createSpecies(@RequestBody Map<String, Object> requestMap) {
        SpeciesEntity species = new SpeciesEntity();
        species.setName((String) requestMap.get("name"));
        species.setGenus((String) requestMap.get("genus"));
        speciesRepository.save(species);
        return ResponseEntity.status(HttpStatus.OK).body("Species created successfully");
    }

    @PutMapping("/associated/species-region")
    public SpeciesEntity associateSpeciesRegion(@RequestBody Map<String, Object> requestMap) {
        Long speciesId = Long.parseLong((String) requestMap.get("species_id"));
        Long regionId = Long.parseLong((String) requestMap.get("region_id"));
        SpeciesEntity species = speciesRepository.findById(speciesId).get();
        RegionEntity region = regionRepository.findById(regionId).get();
        species.regions.add(region);
        return speciesRepository.save(species);
    }

    @PutMapping("/associated/family-species")
    public SpeciesEntity associateFamilyRegion(@RequestBody Map<String, Object> requestMap) {
        Long speciesId = Long.parseLong((String) requestMap.get("species_id"));
        Long familyId = Long.parseLong((String) requestMap.get("family_id"));
        SpeciesEntity species = speciesRepository.findById(speciesId).get();
        FamilyEntity family = familyRepository.findById(familyId).get();
        species.setFamily(family);
        return speciesRepository.save(species);
    }


}
