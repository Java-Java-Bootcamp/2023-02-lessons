package ru.otus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void isAnagram() {
    assertTrue(Main.isAnagram("ANNA".toCharArray()), "ANNA is anagram");
    assertTrue(Main.isAnagram("ANA".toCharArray()), "ANA is anagram");
    assertTrue(Main.isAnagram("".toCharArray()), "'' is anagram");
    assertTrue(Main.isAnagram("A".toCharArray()), "A is anagram");
    assertFalse(Main.isAnagram("PAVEL".toCharArray()), "PAVEL is not anagram");
    assertFalse(Main.isAnagram("PAVE".toCharArray()), "PAVE is not anagram");
    assertFalse(Main.isAnagram("APAVPA".toCharArray()), "APAVPA is not anagram");
  }
}