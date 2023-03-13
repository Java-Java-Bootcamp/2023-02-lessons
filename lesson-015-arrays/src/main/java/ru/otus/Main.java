package ru.otus;

public class Main {

  /**
   * Проверка того, что массив является анаграммой (ANNA)
   * @param a массив для проверки, не null
   * @return true, если анаграмма
   */
  static boolean isAnagram(char[] a) {
    // 0123
    // ANNA
    // 012
    // ANA
    // 0123
    // AXYA
    for (int i = 0; i < a.length / 2; ++i) {
      if (a[i] != a[a.length-1-i])
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

  }
}