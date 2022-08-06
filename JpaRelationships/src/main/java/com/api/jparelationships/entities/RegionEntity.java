package com.api.jparelationships.entities;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;


}
