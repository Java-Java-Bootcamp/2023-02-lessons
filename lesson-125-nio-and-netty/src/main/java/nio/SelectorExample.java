package nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Objects;

@Slf4j
public class SelectorExample {

  public static void main(String[] args) throws IOException {
    Selector selector = Selector.open();

    try (ServerSocketChannel server = ServerSocketChannel.open()) {
      server.configureBlocking(false);
      server.socket().bind(new InetSocketAddress("localhost", 9002));

      log.info("Server started.");
      log.info("Waiting for clients...");

      server.register(selector, SelectionKey.OP_ACCEPT);

      ByteBuffer buffer = ByteBuffer.allocate(48);

      while (true) {
        int readyChannels = selector.selectNow();

        if (readyChannels == 0) {
          continue;
        }

        Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();

        while (selectedKeys.hasNext()) {

          SelectionKey key = selectedKeys.next();

          if (key.isAcceptable()) {
            SocketChannel client = ((ServerSocketChannel) key.channel()).accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            log.info("client connected");
            log.info("Waiting for clients...");

          } else if (key.isReadable()) {
            SocketChannel client = ((SocketChannel) key.channel());
            client.read(buffer);

            buffer.flip();

            StringWriter message = new StringWriter();

            while (buffer.hasRemaining()) {
              message.write(buffer.get());
            }

            log.debug("got the message {}", message);

            if (Objects.equals(message.toString().trim(), "exit")) {
              log.info("close client connection");
              client.close();
            } else {
              buffer.flip();
              buffer.rewind();
              client.write(buffer);
            }
            buffer.clear();
          }

          selectedKeys.remove();
        }
      }
    }
  }
}
