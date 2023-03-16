package ru.otus;

public class InsertionSort {
  static void sort(int[] data) {
    for (var j = 1; j < data.length; ++j) {
      var key = data[j];
      var i = j - 1;
      for (; i >= 0 && data[i] > key; --i) {
        data[i + 1] = data[i];
      }
      data[i + 1] = key;
    }
  }
}
