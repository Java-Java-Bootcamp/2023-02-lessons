package nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class FileWriteExample {

  public static void main(String[] args) throws IOException {

    RandomAccessFile file = new RandomAccessFile("test.txt", "rw");
    FileChannel channel = file.getChannel();
    // append to file
    channel.position(channel.size() - 1);

    ByteBuffer buffer = ByteBuffer.allocate(48);

    String message = """
        text which i want to add
        to the file
        """;

    var messageReader = new StringReader(message);

    int letter;
    while ((letter = messageReader.read()) != -1) {
      if (buffer.hasRemaining()) {
        buffer.put((byte) letter);
      } else {
        //buffer.position=47
        //buffer.limit=47
        buffer.flip();
        //buffer.position=0
        //buffer.limit=47
        channel.write(buffer);
        buffer.clear();
      }
    }
    buffer.flip();
    channel.write(buffer);
    buffer.clear();

    channel.force(true);

    file.close();
  }

}
