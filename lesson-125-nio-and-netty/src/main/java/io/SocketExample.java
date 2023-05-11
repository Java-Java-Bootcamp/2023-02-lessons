package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketExample {

  public static void main(String[] args) throws IOException {
    try (Socket socket = new Socket("google.com", 80)) {

      var out = new PrintStream(socket.getOutputStream());
      var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      out.println("GET /search?q=text HTTP/1.0");
      out.println();
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println(line);
      }

      out.close();
      in.close();
    }
  }

}
