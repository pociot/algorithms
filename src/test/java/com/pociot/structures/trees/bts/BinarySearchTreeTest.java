package com.pociot.structures.trees.bts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
  private static final Logger logger = LogManager.getLogger(BinarySearchTreeTest.class);

  @Test
  void binarySearchTreeTest() {
    BinarySearchTree<Integer> bts = new BinarySearchTree<>();
    bts.insert(50);
    bts.insert(30);
    bts.insert(20);
    bts.insert(40);
    bts.insert(70);
    bts.insert(60);
    bts.insert(80);

    assertEquals("20 30 40 50 60 70 80 ", bts.printInOrder());

    logger.info("\n {}", bts.print2DUtil());

    bts.delete(30);
    bts.delete(60);
    bts.delete(70);

    assertEquals("20 40 50 80 ", bts.printInOrder());

    logger.info("\n {}", bts.print2DUtil());

    bts.delete(50);
    bts.delete(40);
    bts.delete(80);
    bts.delete(20);
    bts.delete(5);
    assertEquals("", bts.printInOrder());

    logger.info("\n {}", bts.print2DUtil());
  }

  @Test
  void minValueTest() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(50);
    bst.insert(30);
    bst.insert(20);
    bst.insert(40);
    bst.insert(70);
    bst.insert(60);
    bst.insert(80);
    bst.insert(80);
    logger.info("\n {}", bst.print2DUtil());
    bst.delete(50);
    logger.info("\n {}", bst.print2DUtil());
  }

}
