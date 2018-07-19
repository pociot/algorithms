package com.pociot.sorting;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SmallSetSortingAlgorithmTest {
  private static final Logger logger = LogManager.getLogger(SortingAlgorithmTest.class);

  private static final String TEST_DATA_SMALL_FILE = "com/pociot/sorting/test-data/integers_small.txt";
  private static final String TEST_DATA_SMALL_SORTED_FILE = "com/pociot/sorting/test-data/integers_small_sorted.txt";

  private List<Integer> unsortedList = null;

  private Integer[] table;
  private Integer[] sortedTable = null;

  @Before
  public void setUp() {
    if (unsortedList == null) {
      InputStream inputStreamUnsorted = getClass().getClassLoader().getResourceAsStream(
          TEST_DATA_SMALL_FILE);
      unsortedList = new ArrayList<>();
      Scanner fileScannerUnsorted = new Scanner(inputStreamUnsorted)
          .useDelimiter(System.getProperty("line.separator"));
      while (fileScannerUnsorted.hasNextInt()) {
        unsortedList.add(fileScannerUnsorted.nextInt());
      }
    }

    if (sortedTable == null) {
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
          TEST_DATA_SMALL_SORTED_FILE);
      List<Integer> list = new ArrayList<>();
      Scanner fileScanner = new Scanner(inputStream)
          .useDelimiter(System.getProperty("line.separator"));
      while (fileScanner.hasNextInt()) {
        list.add(fileScanner.nextInt());
      }
      sortedTable = list.toArray(new Integer[0]);
    }

    table = unsortedList.toArray(new Integer[0]);
  }

  @Test
  public void selectionSortTest() {
    logger.info("Selection sorting started");
    long startDate = System.currentTimeMillis();
    SortingAlgorithm sortingAlgorithm = new SelectionSort();
    Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  @Test
  public void mergeSortTest() {
    logger.info("Merge sorting started");
    long startDate = System.currentTimeMillis();
    SortingAlgorithm sortingAlgorithm = new MergeSort();
    Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  @Test
  public void heapSortTest() {
    logger.info("Heap sorting started");
    long startDate = System.currentTimeMillis();
    SortingAlgorithm sortingAlgorithm = new HeapSort();
    Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  @Test
  public void quickSortTest() {
    logger.info("Quick sorting started");
    long startDate = System.currentTimeMillis();
    SortingAlgorithm sortingAlgorithm = new QuickSort();
    Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  @Test
  public void bubbleSortTest() {
    logger.info("Bubble sorting started");
    long startDate = System.currentTimeMillis();
    SortingAlgorithm sortingAlgorithm = new BubbleSort();
    Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  @Test
  public void shellSortTest() {
    logger.info("Shell sorting started");
    long startDate = System.currentTimeMillis();
    SortingAlgorithm sortingAlgorithm = new ShellSort();
    Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }

  @Test
  public void combSortTest() {
    logger.info("Comb sorting started");
    long startDate = System.currentTimeMillis();
    SortingAlgorithm sortingAlgorithm = new CombSort();
    Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    logger.info("Sorting took {} ms", System.currentTimeMillis() - startDate);
  }
}
