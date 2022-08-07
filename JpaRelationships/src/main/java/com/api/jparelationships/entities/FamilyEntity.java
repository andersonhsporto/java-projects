package com.api.jparelationships.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FamilyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String order;

    private String taxonomyClass;

    private String phylum;

    private String kingdom;

    private String domain;

    @JsonIgnore
    @OneToMany(mappedBy = "family")
    private Set<SpeciesEntity> species;

    public FamilyEntity(String name,
                        String order,
                        String taxonomyClass,
                        String phylum,
                        String kingdom,
                        String domain) {
        this.name = name;
        this.order = order;
        this.taxonomyClass = taxonomyClass;
        this.phylum = phylum;
        this.kingdom = kingdom;
        this.domain = domain;
    }

    public Long getId() {
        return id;
    }

    public Set<SpeciesEntity> getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public String getTaxonomyClass() {
        return taxonomyClass;
    }

    public String getPhylum() {
        return phylum;
    }

    public String getKingdom() {
        return kingdom;
    }

    public String getDomain() {
        return domain;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setTaxonomyClass(String taxonomy_class) {
        this.taxonomyClass = taxonomy_class;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
