package com.api.jparelationships.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FamilyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "family")
    private Set<SpeciesEntity> students;

    private String name;

    private String order;

    private String taxonomy_class;

    private String phylum;

    private String kingdom;

    private String domain;

    public Long getId() {
        return id;
    }

    public Set<SpeciesEntity> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public String getTaxonomy_class() {
        return taxonomy_class;
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

    public void setTaxonomy_class(String taxonomy_class) {
        this.taxonomy_class = taxonomy_class;
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
