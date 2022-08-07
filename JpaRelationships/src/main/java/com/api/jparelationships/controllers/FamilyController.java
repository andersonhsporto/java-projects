package com.api.jparelationships.controllers;

import com.api.jparelationships.entities.DomainEntity;
import com.api.jparelationships.entities.FamilyEntity;
import com.api.jparelationships.entities.SpeciesEntity;
import com.api.jparelationships.repository.DomainRepository;
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

    @Autowired
    DomainRepository domainRepository;

    @GetMapping
    List<FamilyEntity> getAllFamilies() {
        return familyRepository.findAll();
    }
    @PostMapping
    public ResponseEntity createFamily(@RequestBody Map<String, Object> requestMap) {
        FamilyEntity family = new FamilyEntity(
                (String) requestMap.get("name"),
                (String) requestMap.get("order"),
                (String) requestMap.get("taxonomy_class"),
                (String) requestMap.get("phylum"));
        familyRepository.save(family);
        return ResponseEntity.status(HttpStatus.OK).body("Family created successfully");
    }

    @PutMapping("/associated/family-domain")
    public FamilyEntity associateFamilyRegion(@RequestBody Map<String, Object> requestMap) {
        Long familyId = Long.parseLong((String) requestMap.get("family_id"));
        Long domainId = Long.parseLong((String) requestMap.get("domain_id"));
        DomainEntity domain = domainRepository.findById(domainId).get();
        FamilyEntity family = familyRepository.findById(familyId).get();
        family.setDomain(domain);
        return familyRepository.save(family);
    }

}
