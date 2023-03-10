package ru.otus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void plus() {
    assertEquals(5, Main.processLine("2+3"));
  }

  @Test
  void divideDown() {
    assertEquals(2, Main.processLine("8 / 3"));
  }

  @Test
  void divideMath() {
    Main.rounding = Rounding.MATH;
    assertEquals(3, Main.processLine("8 / 3"));
    assertEquals(2, Main.processLine("7 / 3"));
    assertEquals(3, Main.processLine("9 / 3"));
    Main.rounding = Rounding.DOWN;
  }

  @Test
  void processLineError() {
    assertThrows(Exception.class, () -> Main.processLine("x"));
  }
}