package ru.otus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsertionSortTest {
  private int[] data = {9, 7, 6, 15, 17, 5, 10, 11};
  private int[] expected = {5, 6, 7, 9, 10, 11, 15, 17};

  @Test
  void sort0() {
    int[] data = {};
    InsertionSort.sort(data);
  }

  @Test
  void sort1() {
    int[] data = { 10 };
    InsertionSort.sort(data);

    assertEquals(10, data[0]);
  }

  @Test
  void sort() {
    InsertionSort.sort(data);

    assertArrayEquals(expected, data);
  }
}