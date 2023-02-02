package dev.anderson.themeparkapijenkins.entities;

import dev.anderson.themeparkapijenkins.controller.ThemeParkDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ThemeParkRide {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private String description;

  private int thrillFactor;

  private int vomitFactor;

  public ThemeParkRide(String name, String description, int thrillFactor, int vomitFactor) {
    this.name = name;
    this.description = description;
    this.thrillFactor = thrillFactor;
    this.vomitFactor = vomitFactor;
  }

  public static ThemeParkRide fromDTO(ThemeParkDTO themeParkDTO) {
    return new ThemeParkRide(
        themeParkDTO.name(),
        themeParkDTO.description(),
        themeParkDTO.thrillFactor(),
        themeParkDTO.vomitFactor()
    );
  }
}
