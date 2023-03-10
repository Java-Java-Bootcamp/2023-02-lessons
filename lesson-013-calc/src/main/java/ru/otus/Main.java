package ru.otus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Pattern;

public class Main {
  static Rounding rounding = Rounding.DOWN;

  private static final Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*([+/])\\s*(\\d+)");

  private static String readLine() throws IOException {
    return new LineNumberReader(new InputStreamReader(System.in)).readLine();
  }

  static int plus(int a, int b) {
    if (a > 0 && b > 0 && a + b < a) throw new RuntimeException("Overflow");
    if (a < 0 && b < 0 && a + b > a) throw new RuntimeException("Overflow");
    return a + b;
  }

  static int divide(int a, int b) {
    if (rounding == Rounding.DOWN)
      return a / b;
    else
      return (int)Math.round(((double)a) / b);
  }

  static int processLine(String line) {
    var matcher = pattern.matcher(line);
    matcher.find();
    var a = Integer.parseInt(matcher.group(1));
    var b = Integer.parseInt(matcher.group(3));
    var sign = matcher.group(2);
    if (sign.equals("+")) return plus(a, b);
    if (sign.equals("/")) return divide(a, b);
    return 0;
  }

  public static void main(String[] args) throws IOException {
    while (true) {
      System.out.println("Enter expression");
      var line = readLine();
      if (line.equals("exit")) return;
      if (line.equals("round down")) {
        rounding = Rounding.DOWN;
      } else if (line.equals("round math")) {
        rounding = Rounding.MATH;
      } else {
        var result = processLine(line);
        System.out.println(result);
      }
    }
  }
}