package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelExample {

  public static void main(String[] args) throws IOException {
    SocketChannel channel = SocketChannel.open();
    channel.connect(new InetSocketAddress("google.com", 80));

    ByteBuffer buffer = ByteBuffer.allocate(48);
    buffer.put("GET /search?q=test HTTP/1.0\n\n".getBytes());
    buffer.flip();
    channel.write(buffer);
    buffer.clear();

    while (channel.read(buffer) != -1) {
      buffer.flip();

      while (buffer.hasRemaining()) {
        System.out.print((char) buffer.get());
      }
      buffer.clear();
    }
    channel.close();
  }
}
