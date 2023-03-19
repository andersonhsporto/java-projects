package dev.anderson.livraria.repository;

import dev.anderson.livraria.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrariaRepository extends JpaRepository<LivroEntity, Long> {
  boolean existsByNameAndYear(String name, Integer year);
}
