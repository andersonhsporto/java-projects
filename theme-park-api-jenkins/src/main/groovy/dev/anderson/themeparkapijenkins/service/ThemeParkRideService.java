package dev.anderson.themeparkapijenkins.service;

import dev.anderson.themeparkapijenkins.controller.ThemeParkDTO;
import dev.anderson.themeparkapijenkins.entities.ThemeParkRide;
import dev.anderson.themeparkapijenkins.repositories.ThemeParkRideRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ThemeParkRideService {

  private final ThemeParkRideRepository themeParkRideRepository;

  public Iterable<ThemeParkDTO> getRides() {
    return themeParkRideRepository.findAll()
        .stream()
        .map(ThemeParkDTO::fromEntity)
        .toList();
  }

  public ThemeParkDTO getRide(Long id) {
    return themeParkRideRepository.findById(id)
        .map(ThemeParkDTO::fromEntity)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride not found"));
  }

  public ThemeParkDTO createRide(ThemeParkDTO themeParkDTO) {
    return ThemeParkDTO.fromEntity(
        themeParkRideRepository.save(ThemeParkRide.fromDTO(themeParkDTO))
    );
  }

}
