package nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class FileReadExample {

  public static void main(String[] args) throws IOException {

    RandomAccessFile file = new RandomAccessFile("test.txt", "rw");
    FileChannel channel = file.getChannel();

    ByteBuffer buffer = ByteBuffer.allocate(48);

    int bytesRead = channel.read(buffer);
    while (bytesRead != -1) {

      buffer.flip();

      while (buffer.hasRemaining()) {
        System.out.print(buffer.getChar());
      }

      buffer.clear();
      bytesRead = channel.read(buffer);
    }
    file.close();
  }

}
