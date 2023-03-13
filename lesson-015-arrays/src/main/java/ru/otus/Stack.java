package ru.otus;

import java.util.Arrays;

public class Stack {
  private static int[] data = new int[10];
  private static int top = 0;


  static void push(int e) {
    if (top == data.length) {
      /*
      var newData = new int[top + 10];
      for (int i = 0; i < data.length; ++i)
        newData[i] = data[i];
      data = newData;
       */
      data = Arrays.copyOf(data, top + 10);
    }

    data[top] = e;
    top = top + 1;
    /*top += 1;
    ++top;
    data[top++] = e;
     */
  }

  static Integer pop() {
    if (top == 0)
      return null;
    var res = data[top-1];
    top = top - 1;
    return res;
    //return data[--top];
  }

}
