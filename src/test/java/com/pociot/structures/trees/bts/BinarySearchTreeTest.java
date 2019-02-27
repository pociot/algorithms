package com.pociot.structures.trees.bts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pociot.structures.trees.utils.WideTreePrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

  private static final Logger logger = LogManager.getLogger(BinarySearchTreeTest.class);

  @Test
  void binarySearchTreeTest() {
    BinarySearchTree<Integer, String> bts = new BinarySearchTree<>();
    bts.insert(50, "a");
    bts.insert(30, "a");
    bts.insert(20, "a");
    bts.insert(40, "a");
    bts.insert(70, "a");
    bts.insert(60, "a");
    bts.insert(80, "a");

    assertEquals("20 30 40 50 60 70 80 ", bts.printInOrder());

    WideTreePrinter.print(bts.getRoot());

    bts.delete(30);
    bts.delete(60);
    bts.delete(70);

    assertEquals("20 40 50 80 ", bts.printInOrder());

    WideTreePrinter.print(bts.getRoot());

    bts.delete(50);
    bts.delete(40);
    bts.delete(80);
    bts.delete(20);
    bts.delete(5);
    assertEquals("", bts.printInOrder());

    WideTreePrinter.print(bts.getRoot());

  }

  @Test
  void minValueTest() {
    BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
    bst.insert(50, "a");
    bst.insert(30, "a");
    bst.insert(20, "a");
    bst.insert(40, "a");
    bst.insert(70, "a");
    bst.insert(60, "a");
    bst.insert(80, "a");
    bst.insert(80, "a");
    assertEquals("20 30 40 50 60 70 80 80 ", bst.printInOrder());
    logger.info("\n {}", bst.printInOrder());
    bst.delete(50);
    assertEquals("20 30 40 60 70 80 80 ", bst.printInOrder());
    logger.info("\n {}", bst.printInOrder());
  }

}
