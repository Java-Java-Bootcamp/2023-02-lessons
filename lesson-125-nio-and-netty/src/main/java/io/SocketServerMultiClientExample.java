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
public class SocketServerMultiClientExample {

  public static void main(String[] args) throws IOException {
    log.debug("test");
    try (ServerSocket server = new ServerSocket(9002)) {

      log.info("Server created");

      while (true) {
        log.info("Waiting for client...");
        Socket client = server.accept();
        run(client);
      }
    }

  }

  private static void run(Socket client) {
    Thread t = new Thread(() -> {
      try (client) {
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
      } catch (IOException e) {
        log.error("Got the error", e);
      }
    });

    t.start();
  }
}
