package com.api.marketapiql.client.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Collection<Client> findAllByProductsId(Long id);
}
