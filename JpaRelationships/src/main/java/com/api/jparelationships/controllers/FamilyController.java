package com.api.jparelationships.controllers;

import com.api.jparelationships.entities.FamilyEntity;
import com.api.jparelationships.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/families")
public class FamilyController {

    @Autowired
    FamilyRepository familyRepository;
}
