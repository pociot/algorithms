package com.pociot.structures.trees.bts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {
  private static final Logger logger = LogManager.getLogger(BinarySearchTreeTest.class);

  @Test
  public void binarySearchTreeTest() {
    BinarySearchTree<Integer> bts = new BinarySearchTree<>();
    bts.insert(50);
    bts.insert(30);
    bts.insert(20);
    bts.insert(40);
    bts.insert(70);
    bts.insert(60);
    bts.insert(80);

    Assert.assertEquals("20 30 40 50 60 70 80 ", bts.printInOrder());

    logger.info("\n {}", bts.print2DUtil());

    bts.delete(30);
    bts.delete(60);
    bts.delete(70);

    Assert.assertEquals("20 40 50 80 ", bts.printInOrder());

    logger.info("\n {}", bts.print2DUtil());
  }

}
