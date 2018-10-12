package com.pociot.sorting;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class SortingAlgorithmTest extends SortingTestBase {

  private static final String TEST_DATA_FILE = "com/pociot/sorting/test-data/integers.txt";
  private static final String TEST_DATA_SORTED_FILE = "com/pociot/sorting/test-data/integers_sorted.txt";

  private static final boolean RUN_LONG_RUNNING_TESTS = Boolean.getBoolean(System.getProperty("long-running-tests"));

  @Before
  public void setUp() {
    setUp(TEST_DATA_FILE, TEST_DATA_SORTED_FILE);
  }

  @Test
  public void insertionSortTest() {
    Assume.assumeTrue("Long running test.", RUN_LONG_RUNNING_TESTS);
    sortTest(new InsertionSort());
  }

  @Test
  public void selectionSortTest() {
    Assume.assumeTrue("Long running test.", RUN_LONG_RUNNING_TESTS);
    sortTest(new SelectionSort());
  }

  @Test
  public void mergeSortTest() {
    Assume.assumeTrue("Long running test.", RUN_LONG_RUNNING_TESTS);
    sortTest(new MergeSort());
  }

  @Test
  public void heapSortTest() {
    sortTest(new HeapSort());
  }

  @Test
  public void quickSortTest() {
    sortTest(new QuickSort());
  }

  @Test
  public void bubbleSortTest() {
    Assume.assumeTrue("Long running test.", RUN_LONG_RUNNING_TESTS);
    sortTest(new BubbleSort());
  }

  @Test
  public void shellSortTest() {
    sortTest(new ShellSort());
  }

  @Test
  public void combSortTest() {
    sortTest(new CombSort());
  }
}
