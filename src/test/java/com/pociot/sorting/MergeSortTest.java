package com.pociot.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  void getLength() {
    MergeSort mergeSort = new MergeSort();
    assertEquals(0, mergeSort.getLength(null));
  }
}
