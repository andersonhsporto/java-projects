package com.api.jparelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RegionRepository extends JpaRepository<Region, Long> {

}
