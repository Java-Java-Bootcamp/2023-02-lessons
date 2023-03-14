package ru.otus;

import java.util.Arrays;

public class DynamicArray {

  private static String[] data = new String[10];
  private static int length = 0;

  static String get(int index) {
    if (index >= 0 && index < length)
      return data[index];
    return null;
  }

  // true = успех
  static boolean set(int index, String value) {
    if (index >= 0 && index < length) {
      data[index] = value;
      return true;
    }
    return false;
  }

  static void add(String value) {
    insert(length, value);
  }

  // очищает массив, возвращает его в начальное состояние
  static void clear() {
    length = 0;
  }

  //---

  static int length() {
    return length;
  }

  /**
   * Вставляет элемент перед позицией index. Длина массива увеличивается на 1
   * @param index от 0 до length()
   * @param value элемент для вставки
   * @return признак успеха
   */
  static boolean insert(int index, String value) {
    if (index < 0 || index > length) {
      return false;
    }
    // H W X C
    // insert(1, "A")
    // H A W X C
    if (length == data.length) {
      data = Arrays.copyOf(data, length + 10);
    }
    // раздвинуть массив
    // H W X C
    // H W X C C
    // H W X X C
    // H W W X C
    for (int i = length - 1; i >= index; --i) {
      data[i+1] = data[i];
    }

    data[index] = value;
    length += 1;

    return true;
  }

  /**
   * Удаляет элемент на позиции index. Длина массива уменьшается на 1, если удаление успешно
   * @param index от 0 до length()-1* и
   * @return удаленный элемент или null, если удаление не удалось
   */
  static String remove(int index) {
    // проверим допустимость index
    if (index < 0 || index >= length) return null;

    var erased = data[index];

    // сдвинуть все элементы начиная с index+1 на 1 влево
    // Q W E R
    // remove(1) Q E R R
    // remove(0) W E R R
    // remove(3) Q W E R
    for (int i = index + 1; i < length; ++i) {
      data[i-1] = data[i];
    }

    // уменьшить длину
    length -= 1;

    return erased;
  }

  // аналог add, но добавляет много значений сразу
  static void add(String[] values) {
  }

  // аналог insert, но вставляет много значений сразу
  static boolean insert(int index, String[] values) {
    return false;
  }
}
