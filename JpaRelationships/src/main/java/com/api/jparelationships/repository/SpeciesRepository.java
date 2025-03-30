package com.api.jparelationships.repository;

import com.api.jparelationships.entities.SpeciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<SpeciesEntity, Long> {
}
