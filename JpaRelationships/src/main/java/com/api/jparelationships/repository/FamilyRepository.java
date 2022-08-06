package com.api.jparelationships.repository;

import com.api.jparelationships.entities.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FamilyRepository extends JpaRepository<FamilyEntity, Long> {}
