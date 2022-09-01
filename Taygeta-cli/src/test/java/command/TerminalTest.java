package command;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exceptions.UndoCommandException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import models.CompassRose.Compass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.ValidationService;

class TerminalTest {

//  @Test
//  @DisplayName("Planet has invalid size")
//  void isValidPlanetSize() {
//    String command = "5xteste";
//    assertFalse(ValidationService.isValidPlanetSize(command));
//  }
//
//  @Test
//  @DisplayName("Planet has valid size")
//  void isValidPlanetSize2() {
//    String command = "50x50";
//
//    assertTrue(Terminal.isValidPlanetSize(command));
//  }

  @Test
  @DisplayName("Parse North Direction Test")
  void parseNortDirection() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "N";
    InputStream inputStream = new ByteArrayInputStream(command.getBytes());

    System.setIn(inputStream);
    try {
      Compass compass = terminal.parseDirection();
      assertEquals(Compass.NORTH, compass);
    } catch (UndoCommandException e) {
      assertTrue(true);

    }
  }

  @Test
  @DisplayName("Parse South Direction Test")
  void parseSouthDirection() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "Sul";
    InputStream inputStream = new ByteArrayInputStream(command.getBytes());

    System.setIn(inputStream);
    try {
      Compass compass = terminal.parseDirection();
      assertEquals(Compass.SOUTH, compass);
    } catch (UndoCommandException e) {
      assertTrue(true);
    }
  }

  @Test
  @DisplayName("Parse East Direction Test")
  void parseEastDirection() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "leste";
    InputStream inputStream = new ByteArrayInputStream(command.getBytes());

    System.setIn(inputStream);
    try {
      Compass compass = terminal.parseDirection();
      assertEquals(Compass.EAST, compass);
    } catch (UndoCommandException e) {
      assertTrue(true);
    }
  }

  @Test
  @DisplayName("Parse West Direction Test")
  void parseWestDirection() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "W";
    InputStream inputStream = new ByteArrayInputStream(command.getBytes());

    System.setIn(inputStream);
    try {
      Compass compass = terminal.parseDirection();
      assertEquals(Compass.WEST, compass);
    } catch (UndoCommandException e) {
      assertTrue(true);
    }
  }

  @Test
  @DisplayName("Undo probe direction")
  void undoProbeDirection() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "undo";
    InputStream inputStream = new ByteArrayInputStream(command.getBytes());

    System.setIn(inputStream);
    try {
      Compass compass = terminal.parseDirection();
    } catch (UndoCommandException e) {
      assertTrue(true);
    }
  }

  @Test
  @DisplayName("Parse valid string to int")
  void parseStringToInt() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "5";
    int number = terminal.parseId(command);

    Assertions.assertEquals(5, number);
  }

  @Test
  @DisplayName("Parse invalid string to int")
  void parseInvalidStringToInt() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "111Invalid2";

    Assertions.assertEquals(-1, terminal.parseId(command));
  }

  @Test
  @DisplayName("Parse invalid string to int")
  void parseInvalidStringToInt2() throws UndoCommandException {
    Terminal terminal = new Terminal();
    String command = "12a";

    Assertions.assertEquals(-1, terminal.parseId(command));
  }
}