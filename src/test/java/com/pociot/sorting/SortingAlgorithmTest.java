package com.pociot.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class SortingAlgorithmTest extends SortingTestBase {

  private static final String TEST_DATA_FILE = "com/pociot/sorting/test-data/integers.txt";
  private static final String TEST_DATA_SORTED_FILE = "com/pociot/sorting/test-data/integers_sorted.txt";

  private static final String LONG_RUNNING_TESTS = "long-running-tests";

  private static final String CI = "CI";

  @BeforeEach
  void setUp() {
    setUp(TEST_DATA_FILE, TEST_DATA_SORTED_FILE);
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void insertionSortTest() {
    sortTest(new InsertionSort());
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void selectionSortTest() {
    sortTest(new SelectionSort());
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void mergeSortTest() {
    sortTest(new MergeSort());
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void heapSortTest() {
    sortTest(new HeapSort());
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void quickSortTest() {
    sortTest(new QuickSort());
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void bubbleSortTest() {
    sortTest(new BubbleSort());
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void shellSortTest() {
    sortTest(new ShellSort());
  }

  @Test
  @EnabledIfSystemProperty(named = LONG_RUNNING_TESTS, matches = "true")
  void combSortTest() {
    sortTest(new CombSort());
  }
}
