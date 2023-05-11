package io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;


@Slf4j
public class SocketServerExample {

  public static void main(String[] args) throws IOException {
    log.debug("test");
    try (ServerSocket server = new ServerSocket(9001)) {

      log.info("server created. Ready to accept");

      try (Socket client = server.accept()) {
        log.info("client connected");

        PrintWriter out = new PrintWriter(client.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String line;

        while (!Objects.equals(line = in.readLine(), "exit")) {
          log.debug("got the message {}", line);
          out.println(line);
          out.flush();
        }
        log.info("client connected");
      }
    }
  }
}
