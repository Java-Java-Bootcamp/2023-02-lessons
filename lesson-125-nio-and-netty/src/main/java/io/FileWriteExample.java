package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteExample {

  public static void main(String[] args) throws IOException {

    try (PrintWriter out = new PrintWriter(new FileOutputStream("test.txt", true))) {
      out.println("Another line 1");
      out.println("Another line 2");
    }
  }
}
