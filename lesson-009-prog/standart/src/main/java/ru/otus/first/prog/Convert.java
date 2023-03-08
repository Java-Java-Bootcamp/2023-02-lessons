package ru.otus.first.prog;

public class Convert {
  public static void main(String[] args) {
    int x = 2_000_000_001;
    float t = x;
    System.out.println(t);

    /*for (int i = 0; i < 1_000_000; ++i)
      t += 1;
    */
    //t += 1_000_000;

    System.out.println((int)t - x);
  }
}
