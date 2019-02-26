package com.pociot.structures.trees.rbtree;

import com.pociot.structures.trees.utils.TallTreePrinter;
import com.pociot.structures.trees.utils.WideTreePrinter;
import org.junit.jupiter.api.Test;

class RebBlackTreeTest {

  @Test
  void someTest() {
    RedBlackTree<Integer> bst = new RedBlackTree<>();
    bst.insert(5);
    bst.insert(3);
    bst.insert(2);
    bst.insert(4);
    bst.insert(7);
    bst.insert(6);
    bst.insert(8);
    bst.insert(9);
    bst.insert(1);
    bst.insert(0);
    TallTreePrinter.printNode(bst.root);
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
    TallTreePrinter.printNode(bst.root);
  }

  @Test
  void anotherTest() {
    RedBlackTree<Integer> bst = new RedBlackTree<>();
    for (int i = 0; i < 25; i++) {
      bst.insert(i);
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

    WideTreePrinter.print(bst.root);
  }
}
