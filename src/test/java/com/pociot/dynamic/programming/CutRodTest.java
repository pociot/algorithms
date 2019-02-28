package com.pociot.dynamic.programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class CutRodTest {

  private final Logger logger = LogManager.getLogger(CutRodTest.class);


  private final int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  private final Map<Integer, Integer> dataSet = Map.of(
      1, 1,
      2, 5,
      3, 8,
      4, 10,
      5, 13,
      6, 17,
      7, 18,
      8, 22,
      9, 25,
      10, 30
  );


  @Test
  void recursiveCutRodTest() {
    dataSet.forEach((key, value) -> assertEquals(value, CutRod.recursiveCutRod(this.p, key)));
  }

  @Test
  void memorizedCutRodTest() {
    dataSet.forEach((key, value) -> assertEquals(value, CutRod.memorizedCutRod(this.p, key)));
  }

  @Test
  void bottomUpCutRodTest() {
    dataSet.forEach((key, value) -> assertEquals(value, CutRod.bottomUpCutRod(this.p, key)));
  }

  @Test
  void printAllSolutions() {
    dataSet.forEach((key, value) -> logger.info("Solution for {} is: {}",
        key, CutRod.printCutRodSolution(this.p, key)));
  }
}
