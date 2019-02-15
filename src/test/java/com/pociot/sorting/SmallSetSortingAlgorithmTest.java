package com.pociot.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

class SmallSetSortingAlgorithmTest extends SortingTestBase{

  private static final String TEST_DATA_SMALL_FILE = "com/pociot/sorting/test-data/integers_small.txt";
  private static final String TEST_DATA_SMALL_SORTED_FILE = "com/pociot/sorting/test-data/integers_small_sorted.txt";

  @BeforeEach
  void setUp() {
    setUp(TEST_DATA_SMALL_FILE, TEST_DATA_SMALL_SORTED_FILE);
  }

  @Test
  void selectionSortTest() {
    sortTest(new SelectionSort());
  }

  @Test
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

  @Test
  @DisabledIfEnvironmentVariable(named = "TRAVIS", matches = "true")
  void shouldThrowIllegalArgumentException() {
    //noinspection ConstantConditions
    Assertions.assertThrows(IllegalArgumentException.class, () -> new MergeSort().sort(null));
  }

  @Test
  @EnabledIfEnvironmentVariable(named = "TRAVIS", matches = "true")
  void shouldThrowNullPointerException() {
    //noinspection ConstantConditions
    Assertions.assertThrows(NullPointerException.class, () -> new MergeSort().sort(null));
  }
}
