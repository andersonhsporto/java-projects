package dev.anderson.peopleapi.repositories;

import dev.anderson.peopleapi.domain.entities.PeopleEntity;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {

  boolean existsByNameAndBirthDate(String name, LocalDate birthDate);
}