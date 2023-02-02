package dev.anderson.themeparkapijenkins.controller;

import dev.anderson.themeparkapijenkins.service.ThemeParkRideService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ride")
@AllArgsConstructor
@CrossOrigin("*")
public class ThemeParkRideController {

  private final ThemeParkRideService themeParkRideService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<ThemeParkDTO> getRides() {
    return themeParkRideService.getRides();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ThemeParkDTO getRide(@PathVariable Long id) {
    return themeParkRideService.getRide(id);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ThemeParkDTO createRide(@RequestBody ThemeParkDTO themeParkRide) {
    return themeParkRideService.createRide(themeParkRide);
  }

}
