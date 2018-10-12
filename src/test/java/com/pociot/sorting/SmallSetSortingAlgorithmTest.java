package com.pociot.sorting;

import org.junit.Before;
import org.junit.Test;

public class SmallSetSortingAlgorithmTest extends SortingTestBase{

  private static final String TEST_DATA_SMALL_FILE = "com/pociot/sorting/test-data/integers_small.txt";
  private static final String TEST_DATA_SMALL_SORTED_FILE = "com/pociot/sorting/test-data/integers_small_sorted.txt";

  @Before
  public void setUp() {
    setUp(TEST_DATA_SMALL_FILE, TEST_DATA_SMALL_SORTED_FILE);
  }

  @Test
  public void selectionSortTest() {
    sortTest(new SelectionSort());
  }

  @Test
  public void mergeSortTest() {
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
