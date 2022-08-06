package com.api.jparelationships.repository;

import com.api.jparelationships.entities.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RegionRepository extends JpaRepository<RegionEntity, Long> {}
