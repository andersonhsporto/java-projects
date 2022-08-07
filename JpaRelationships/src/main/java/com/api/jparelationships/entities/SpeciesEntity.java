package com.api.jparelationships.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SpeciesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String genus;

    @ManyToMany
    @JoinTable(
            name = "regions_species",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id")
    )
    public Set<RegionEntity> regions = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "family_id", referencedColumnName = "id")
    private FamilyEntity family;

    public Long getId() {
        return id;
    }

    public FamilyEntity getFamily() {
        return family;
    }

    public void setFamily(FamilyEntity family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}
