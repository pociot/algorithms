package com.pociot.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

public class SortingAlgorithmTest extends SortingTestBase {

  private static final String TEST_DATA_FILE = "com/pociot/sorting/test-data/integers.txt";
  private static final String TEST_DATA_SORTED_FILE = "com/pociot/sorting/test-data/integers_sorted.txt";

  private static final String LONG_RUNNING_TESTS = "long-running-tests";

  @BeforeEach
  void setUp() {
    setUp(TEST_DATA_FILE, TEST_DATA_SORTED_FILE);
  }

  @Test
  @DisabledIfEnvironmentVariable(named = LONG_RUNNING_TESTS, matches = "false")
  void insertionSortTest() {
    sortTest(new InsertionSort());
  }

  @Test
  @DisabledIfEnvironmentVariable(named = LONG_RUNNING_TESTS, matches = "false")
  void selectionSortTest() {
    sortTest(new SelectionSort());
  }

  @Test
  @DisabledIfEnvironmentVariable(named = LONG_RUNNING_TESTS, matches = "false")
  void mergeSortTest() {
    sortTest(new MergeSort());
  }

  @Test
  void heapSortTest() {
    sortTest(new HeapSort());
  }

  @Test
  void quickSortTest() {
    sortTest(new QuickSort());
  }

  @Test
  @DisabledIfEnvironmentVariable(named = LONG_RUNNING_TESTS, matches = "false")
  void bubbleSortTest() {
    sortTest(new BubbleSort());
  }

  @Test
  void shellSortTest() {
    sortTest(new ShellSort());
  }

  @Test
  void combSortTest() {
    sortTest(new CombSort());
  }
}
