package com.api.jparelationships.controllers;

import com.api.jparelationships.entities.FamilyEntity;
import com.api.jparelationships.entities.RegionEntity;
import com.api.jparelationships.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @PostMapping
    public ResponseEntity createRegion(@RequestBody Map<String, Object> requestMap) {
        RegionEntity region = new RegionEntity();
        region.setName((String) requestMap.get("name"));
        region.setCountry((String) requestMap.get("country"));
        region.setGeographicalRegion((String) requestMap.get("geographical_region"));
        regionRepository.save(region);
        return ResponseEntity.status(HttpStatus.OK).body("Region created successfully");
    }

}
