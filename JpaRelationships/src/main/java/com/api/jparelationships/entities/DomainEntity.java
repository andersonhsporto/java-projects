package com.api.jparelationships.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String kingdom;

    @JsonIgnore
    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
    private Set<FamilyEntity> families;


    public DomainEntity(String name,
                        String kingdom) {
        this.name = name;
        this.kingdom = kingdom;
    }

    public DomainEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKingdom() {
        return kingdom;
    }

    public Set<FamilyEntity> getFamilies() {
        return families;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }
}
