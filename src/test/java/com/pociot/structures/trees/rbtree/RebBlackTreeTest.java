package com.pociot.structures.trees.rbtree;

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
    bst.delete(0);
    bst.delete(1);
    bst.delete(2);
    bst.delete(3);
    bst.delete(4);
    bst.delete(5);
    bst.delete(6);
    bst.delete(7);
    bst.delete(8);
    bst.delete(9);

    WideTreePrinter.print(bst.getRoot());
  }
}
