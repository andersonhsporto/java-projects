package com.api.jparelationships.controllers;

import com.api.jparelationships.entities.FamilyEntity;
import com.api.jparelationships.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/families")
public class FamilyController {

    @Autowired
    FamilyRepository familyRepository;

    @GetMapping
    List<FamilyEntity> getAllFamilies() {
        return familyRepository.findAll();
    }
    @PostMapping
    public ResponseEntity createFamily(@RequestBody Map<String, Object> requestMap) {
        FamilyEntity family = new FamilyEntity();
        family.setName((String) requestMap.get("name"));
        family.setOrder((String) requestMap.get("order"));
        family.setTaxonomyClass((String) requestMap.get("taxonomy_class"));
        family.setPhylum((String) requestMap.get("phylum"));
        family.setKingdom((String) requestMap.get("kingdom"));
        family.setDomain((String) requestMap.get("domain"));
        familyRepository.save(family);
        return ResponseEntity.status(HttpStatus.OK).body("Family created successfully");
    }
}
