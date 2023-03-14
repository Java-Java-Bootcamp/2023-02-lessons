package ru.otus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

  @BeforeEach
  void beforeEach() {
    DynamicArray.clear();
  }

  @Test
  void get_when_empty_array() {
    assertNull(DynamicArray.get(0));
    assertNull(DynamicArray.get(1));
  }

  @Test
  void get_after_add() {
    DynamicArray.add("Hello");
    DynamicArray.add("World");

    assertEquals("Hello", DynamicArray.get(0));
    assertEquals("World", DynamicArray.get(1));
  }

  @Test
  void get_after_set() {
    DynamicArray.add("Hello");
    DynamicArray.add("World");
    assertTrue(DynamicArray.set(0, "Goodbye"));

    assertEquals("Goodbye", DynamicArray.get(0));
    assertEquals("World", DynamicArray.get(1));
  }

  @Test
  void set() {
    DynamicArray.add("Hello");
    assertTrue(DynamicArray.set(0, "Goodbye"));
    assertFalse(DynamicArray.set(1, "World"));
    assertFalse(DynamicArray.set(-1, "Hello"));
  }

  @Test
  void many_adds() {
    for (int i = 0; i < 500; ++i) {
      DynamicArray.add(Integer.toString(i));
    }

    for (int i = 0; i < 500; ++i) {
      assertEquals(Integer.toString(i), DynamicArray.get(i));
    }
    assertNull(DynamicArray.get(500));
  }

  @Test
  void length() {
    assertEquals(0, DynamicArray.length());

    DynamicArray.add("Hello");
    assertEquals(1, DynamicArray.length());

    assertTrue(DynamicArray.set(0, "Goodbye"));
    assertEquals(1, DynamicArray.length());
  }

  @Test
  void insert() {
    assertTrue(DynamicArray.insert(0, "world"));
    assertTrue(DynamicArray.insert(0, "Hello"));
    assertTrue(DynamicArray.insert(2, "!"));
    assertFalse(DynamicArray.insert(4, "?"));

    assertEquals(3, DynamicArray.length());
    assertEquals("Hello", DynamicArray.get(0));
    assertEquals("world", DynamicArray.get(1));
    assertEquals("!", DynamicArray.get(2));
  }

  @Test
  void remove() {
    DynamicArray.add("Hello");
    DynamicArray.add("World");

    assertEquals("Hello", DynamicArray.remove(0));
    assertNull(DynamicArray.remove(1));
    assertNull(DynamicArray.remove(-1));

    assertTrue(DynamicArray.insert(0, "hello"));
    assertEquals("World", DynamicArray.remove(1));

    assertEquals("hello", DynamicArray.get(0));
    assertEquals("hello", DynamicArray.remove(0));

    assertEquals(0, DynamicArray.length());
  }
}