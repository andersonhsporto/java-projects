package dev.anderson.jwtexample.repository;

import dev.anderson.jwtexample.entities.RoleEntity;
import dev.anderson.jwtexample.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    Optional<RoleEntity> findByRoleName(RoleName roleName);
}
