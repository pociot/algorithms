package com.pociot.structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pociot.structures.CustomLinkedList.Link;
import org.junit.jupiter.api.Test;

class CustomLinkedListTest {

  @Test
  void testLinkedList() {
    CustomLinkedList<Integer> list = new CustomLinkedList<>();

    list.push(1);
    list.push(2);
    list.push(3);
    list.push(4);
    list.insertAfter(list.getHead().getNext(), 10);
    list.push(5);
    list.append(9);
    list.append(8);
    list.append(7);

    assertEquals((Integer) 5, list.getHead().getValue());
    assertEquals((Integer) 5, list.delete().getValue());

    assertEquals((Integer) 4, list.getHead().getValue());
    assertEquals((Integer) 4, list.delete().getValue());

    assertEquals((Integer) 3, list.getHead().getValue());
    assertEquals((Integer) 3, list.delete().getValue());

    assertEquals((Integer) 10, list.getHead().getValue());
    assertEquals((Integer) 10, list.delete().getValue());

    assertEquals((Integer) 2, list.getHead().getValue());
    assertEquals((Integer) 2, list.delete().getValue());

    assertEquals((Integer) 1, list.getHead().getValue());
    assertEquals((Integer) 1, list.delete().getValue());

    assertEquals((Integer) 9, list.getHead().getValue());
    assertEquals((Integer) 9, list.delete().getValue());

    assertEquals((Integer) 8, list.getHead().getValue());
    assertEquals((Integer) 8, list.delete().getValue());

    assertEquals((Integer) 7, list.getHead().getValue());
    assertEquals((Integer) 7, list.delete().getValue());

    assertNull(list.delete());
    assertNull(list.getHead());
  }

  @Test
  void shouldThrowIllegalArgumentException() {
    CustomLinkedList<Integer> list = new CustomLinkedList<>();
    assertThrows(IllegalArgumentException.class, () -> list.insertAfter(null, null));
  }

  @Test
  void shouldAppendToHead() {
    CustomLinkedList<Integer> list = new CustomLinkedList<>();
    list.append(1);
    assertEquals(1, list.getHead().getValue());
  }

  @Test
  void shouldCompleteSearchWithoutErrors() {
    CustomLinkedList<Integer> list = new CustomLinkedList<>();
    list.push(1);
    list.push(2);
    Link<Integer> link = list.search(1);
    assertEquals(link.getValue(), 1);
    link = list.search(3);
    assertNull(link);
  }
}
