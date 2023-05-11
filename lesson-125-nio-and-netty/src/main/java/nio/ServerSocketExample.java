package nio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.Objects;

@Slf4j
public class ServerSocketExample {

  public static void main(String[] args) throws IOException {
    try (ServerSocketChannel server = ServerSocketChannel.open()) {
      server.socket().bind(new InetSocketAddress("localhost", 9002));

      log.info("Server started.");

      while (true) {
        log.info("Waiting for clients...");
        try (Socket client = server.socket().accept()) {
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

}
