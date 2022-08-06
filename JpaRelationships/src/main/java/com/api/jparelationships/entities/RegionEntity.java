package com.api.jparelationships.entities;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String country;

    private String geographical_region;

}
