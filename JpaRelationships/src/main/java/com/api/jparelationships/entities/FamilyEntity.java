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

    @JsonIgnore
    @OneToMany(mappedBy = "family")
    private Set<SpeciesEntity> species;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domain_id", referencedColumnName = "id")
    private DomainEntity domain;

    public FamilyEntity(String name,
                        String order,
                        String taxonomyClass,
                        String phylum) {
        this.name = name;
        this.order = order;
        this.taxonomyClass = taxonomyClass;
        this.phylum = phylum;
    }

    public FamilyEntity() {

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

    public DomainEntity getDomain() {
        return domain;
    }

    public void setDomain(DomainEntity domain) {
        this.domain = domain;
    }
}
