package com.pociot.structures.trees.rbtree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pociot.structures.trees.utils.WideTreePrinter;
import org.junit.jupiter.api.Test;

class RebBlackTreeTest {

  @Test
  void someTest() {
    RedBlackTree<Integer, String> bst = new RedBlackTree<>();
    bst.insert(5, "a");
    bst.insert(3, "a");
    bst.insert(2, "a");
    bst.insert(4, "a");
    bst.insert(7, "a");
    bst.insert(6, "a");
    bst.insert(8, "a");
    bst.insert(9, "a");
    bst.insert(1, "a");
    bst.insert(0, "a");
    WideTreePrinter.print(bst.getRoot());
    assertEquals("0 1 2 3 4 5 6 7 8 9 ", bst.printInOrder());
    bst.delete(3);
    bst.delete(6);
    bst.delete(7);
    bst.delete(0);
    bst.delete(1);
    bst.delete(4);
    bst.delete(5);
    bst.delete(2);
    bst.delete(9);
    bst.delete(8);
  }

  @Test
  void anotherTest() {
    RedBlackTree<Integer, String> bst = new RedBlackTree<>();
    for (int i = 0; i < 25; i++) {
      bst.insert(i, "a");
    }
    assertEquals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(0);
    assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(1);
    assertEquals("2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(2);
    assertEquals("3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(3);
    assertEquals("4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(4);
    assertEquals("5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(5);
    assertEquals("6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(6);
    assertEquals("7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(7);
    assertEquals("8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(8);
    assertEquals("9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());
    bst.delete(9);
    assertEquals("10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ",
        bst.printInOrder());

    WideTreePrinter.print(bst.getRoot());
  }
}
