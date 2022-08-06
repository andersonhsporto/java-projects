package com.api.jparelationships.controllers;

import com.api.jparelationships.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    SpeciesRepository speciesRepository;

}
