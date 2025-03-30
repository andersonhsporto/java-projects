package dev.anderson.themeparkapijenkins.repositories;

import dev.anderson.themeparkapijenkins.entities.ThemeParkRide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeParkRideRepository extends JpaRepository<ThemeParkRide, Long> {

}
