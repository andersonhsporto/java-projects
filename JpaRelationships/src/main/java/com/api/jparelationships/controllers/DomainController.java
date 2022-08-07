package com.api.jparelationships.controllers;

import com.api.jparelationships.entities.DomainEntity;
import com.api.jparelationships.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    DomainRepository domainRepository;

    @GetMapping
    List<DomainEntity> getAllDomains() {
        return domainRepository.findAll();
    }

    @PostMapping
    public ResponseEntity createDomain(@RequestBody Map<String, Object> requestMap) {
        DomainEntity domain = new DomainEntity(
                (String) requestMap.get("name"),
                (String) requestMap.get("kingdom"));
        domainRepository.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body("Domain created successfully");
    }

}
