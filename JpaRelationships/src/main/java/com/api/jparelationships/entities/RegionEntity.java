package com.api.jparelationships.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String country;

    private String geographicalRegion;

    @JsonIgnore
    @ManyToMany(mappedBy = "regions")
    private Set<SpeciesEntity> species = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeographicalRegion() {
        return geographicalRegion;
    }

    public void setGeographicalRegion(String geographicalRegion) {
        this.geographicalRegion = geographicalRegion;
    }
}
