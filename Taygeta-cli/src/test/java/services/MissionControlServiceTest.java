package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import models.CompassRose;
import models.CompassRose.Cardinal;
import models.Planet;
import models.Probe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MissionControlServiceTest {

  @Test
  @DisplayName("Test add Planet of size 5x5")
  void add5x5Planet() {
    MissionControlService missionControlService = new MissionControlService();
    missionControlService.addPlanet("5x5");
    assertEquals(1, missionControlService.getPlanets().size());
  }

  @Test
  @DisplayName("Add one probe to planet")
  void addOneProbeToPlanet() {
    MissionControlService missionControlService = new MissionControlService();
    missionControlService.addPlanet("10x10");
    missionControlService.addProbeToPlanet(new Probe(1, 0, 0, Cardinal.NORTH), 0);
    assertEquals(1, missionControlService.getPlanets().size());
  }

  @Test
  @DisplayName("Size of planets list is 5")
  void sizeOfPlanetsListIs5() {
    MissionControlService missionControlService = new MissionControlService();
    missionControlService.addPlanet("5x5");
    missionControlService.addPlanet("7x1");
    missionControlService.addPlanet("1x3");
    missionControlService.addPlanet("4x9");
    missionControlService.addPlanet("42x42");
    assertEquals(5, missionControlService.getPlanets().size());
  }

  @Test
  @DisplayName("Size of planets list is 0")
  void sizeOfPlanetsListIs0() {
    MissionControlService missionControlService = new MissionControlService();
    assertEquals(0, missionControlService.getPlanets().size());
  }

  @Test
  @DisplayName("Size of planets list is 1")
  void sizeOfPlanetsListIs1() {
    MissionControlService missionControlService = new MissionControlService();
    missionControlService.addPlanet("5x5");
    assertEquals(1, missionControlService.getPlanets().size());
  }


  @Test
  @DisplayName("Move probe using LMLMLMLMM sequence")
  void moveProveUsingLMLMLMLMMSequence() {
    MissionControlService missionControlService = new MissionControlService();
    Probe tempProbe = new Probe(0, 1, 2, Cardinal.NORTH);
    Planet planet = new Planet(0, 5, 5);
    Probe cloneProbe = missionControlService.cloneUpdateProbe(tempProbe, planet, "LMLMLMLMM");

    assertEquals(new Point(1, 3), cloneProbe.getPoint());
    assertEquals(Cardinal.NORTH, cloneProbe.getDirection());
  }

  @Test
  @DisplayName("Move probe using MMRMMRMRRML sequence")
  void moveProveUsingMMRMMRMRRMLSequence() {
    MissionControlService missionControlService = new MissionControlService();
    Probe tempProbe = new Probe(0, 3, 3, Cardinal.EAST);
    Planet planet = new Planet(0, 5, 5);
    Probe cloneProbe = missionControlService.cloneUpdateProbe(tempProbe, planet, "MMRMMRMRRML");

    assertEquals(new Point(5, 1), cloneProbe.getPoint());
    assertEquals(Cardinal.NORTH, cloneProbe.getDirection());
  }
}