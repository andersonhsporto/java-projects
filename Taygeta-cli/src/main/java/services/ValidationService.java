package services;

import java.util.Collection;
import java.util.Optional;
import models.Planet;

public class ValidationService {

  public static boolean commandInPlanetSizeFormat(String command) {
    var commandArray = command.split("x");

    if (commandArray.length != 2) {
      return false;
    }
    try {
      int width = Integer.parseInt(commandArray[0]);
      int height = Integer.parseInt(commandArray[1]);

      if (width < 1 || height < 1) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  public static boolean planetExists(MissionControlService missionControlService) {
    return !missionControlService.getPlanets().isEmpty();
  }

  public static boolean planetIsValid(String command, MissionControlService missionControlService) {
    if (planetExistsById(command, missionControlService)) {
      return !missionControlService.planetByIdIsFull(ParseService.id(command));
    } else {
      return false;
    }
  }

  public static boolean planetExistsById(
      String command, MissionControlService missionControlService) {

    int planetId = ParseService.id(command);
    Collection<Planet> planets = missionControlService.getPlanets();

    if (planetId >= 0 && planetId < planets.size()) {
      return true;
    } else {
      System.out.println(MessageService.red("planet id: " + command + " does not exist"));
      return false;
    }
  }

  public static boolean probeExists(
      Integer planetId, int probeId, MissionControlService missionControlService) {

    Optional<Planet> planet = missionControlService.getPlanetById(planetId);

    return planet.filter(value -> probeId >= 0 && probeId < value.getProbes().size()).isPresent();
  }

  public static boolean isValidSequence(String command) {
    return command.matches("^[MLR]+$");
  }

  public static boolean isValidCardinal(String command) {
    String lowerCaseCommand = command.toLowerCase();

    return switch (lowerCaseCommand) {
      case "north", "south", "east", "west", "norte", "sul", "leste", "oeste" -> true;
      case "n", "s", "e", "l", "w", "o" -> true;
      default -> false;
    };
  }
}
