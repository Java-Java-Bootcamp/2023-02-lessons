package nio;

import java.nio.ByteBuffer;

public class BufferExample {

  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(25);

    buffer.put((byte) 1);
    buffer.put((byte) 2);
    buffer.put((byte) 3);

    buffer.flip();

    byte i = buffer.get();
    System.out.println(i);
    i = buffer.get();
    System.out.println(i);
    i = buffer.get();
    System.out.println(i);
  }


}
