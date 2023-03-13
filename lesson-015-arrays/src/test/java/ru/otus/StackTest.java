package ru.otus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void test() {
    assertNull(Stack.pop());

    Stack.push(5);
    assertEquals(5, Stack.pop());

    Stack.push(42);
    Stack.push(3);
    assertEquals(3, Stack.pop());
    assertEquals(42, Stack.pop());
    assertNull(Stack.pop());

    Stack.push(42);
    Stack.push(3);
    assertEquals(3, Stack.pop());
    Stack.push(27);
    assertEquals(27, Stack.pop());
    assertEquals(42, Stack.pop());
    assertNull(Stack.pop());

    for (int i = 0; i <50; ++i)
      Stack.push(i);
    for (int i = 49; i >= 0; --i)
      assertEquals(i, Stack.pop());
    assertNull(Stack.pop());
  }
}