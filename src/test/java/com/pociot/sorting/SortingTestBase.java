package com.pociot.sorting;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

class SortingTestBase {

  private static final Logger logger = LogManager.getLogger(SortingAlgorithmTest.class);

  private List<Integer> unsortedList = null;

  private Integer[] table;
  private Integer[] sortedTable = null;

  void sortTest(SortingAlgorithm algorithm) {
    logger.info("{} started", algorithm.getClass());
    long startDate = System.currentTimeMillis();
    Assert.assertArrayEquals(sortedTable, algorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  void setUp(String unsortedFilePath, String sortedFilePath) {
    initializeUnsortedList(unsortedFilePath);
    Assert.assertNotNull(unsortedList);
    initializeSortedArray(sortedFilePath);
    Assert.assertNotNull(sortedTable);
    initializeUnsortedArray();
    Assert.assertNotNull(table);
  }

  private void initializeUnsortedList(String filePath) {
    if (unsortedList == null) {
      unsortedList = readFileToIntegerList(filePath);
    }
  }

  private void initializeSortedArray(String filePath) {
    if (sortedTable == null) {
      sortedTable = readFileToIntegerList(filePath).toArray(new Integer[0]);
    }
  }

  private void initializeUnsortedArray() {
    if (unsortedList != null) {
      table = unsortedList.toArray(new Integer[0]);
    }
  }

  private List<Integer> readFileToIntegerList(String filePath) {
    InputStream inputStreamUnsorted = getClass().getClassLoader().getResourceAsStream(
        filePath);
    List<Integer> integerList = new ArrayList<>();
    Scanner fileScannerUnsorted = new Scanner(inputStreamUnsorted)
        .useDelimiter(System.getProperty("line.separator"));
    while (fileScannerUnsorted.hasNextInt()) {
      integerList.add(fileScannerUnsorted.nextInt());
    }
    return integerList;
  }
}
