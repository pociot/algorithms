package com.pociot.structures.trees.rbtree;

import com.pociot.structures.trees.utils.TreePrinter;
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
    bst.insert(8);
    TreePrinter.printNode(bst.root);
  }
}
