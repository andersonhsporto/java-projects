package com.api.jparelationships.repository;

import com.api.jparelationships.entities.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<DomainEntity, Long> {
}
