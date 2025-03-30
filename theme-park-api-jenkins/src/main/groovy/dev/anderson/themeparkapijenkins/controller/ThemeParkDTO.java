package dev.anderson.themeparkapijenkins.controller;

import dev.anderson.themeparkapijenkins.entities.ThemeParkRide;

public record ThemeParkDTO(String name, String description, int thrillFactor, int vomitFactor) {

  public static ThemeParkDTO fromEntity(ThemeParkRide themeParkRide) {
    return new ThemeParkDTO(
        themeParkRide.getName(),
        themeParkRide.getDescription(),
        themeParkRide.getThrillFactor(),
        themeParkRide.getVomitFactor()
    );
  }
}

