package com.pociot.sorting;

import org.jetbrains.annotations.NotNull;

public class HeapSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(@NotNull T[] array) {
    T[] returnArray = arrayCopyOf(array, array.length);
    heapSort(returnArray);
    return returnArray;
  }

  private <T extends Number & Comparable<? super T>> void maxHeapify(T[] array, int i,
      int heapSize) {
    int maxIndex = i;
    int l = left(i);
    int r = right(i);

    if (l < heapSize && array[l].compareTo(array[i]) > 0) {
      maxIndex = l;
    }

    if (r < heapSize && array[r].compareTo(array[maxIndex]) > 0) {
      maxIndex = r;
    }

    if (maxIndex != i) {
      swap(array, i, maxIndex);
      maxHeapify(array, maxIndex, heapSize);
    }
  }

  private <T extends Number & Comparable<? super T>> void buildMaxHeap(T[] array) {
    for (int i = (array.length / 2) - 1; i >= 0; i--) {
      maxHeapify(array, i, array.length);
    }
  }

  private <T extends Number & Comparable<? super T>> void heapSort(T[] array) {
    buildMaxHeap(array);
    for (int i = array.length - 1; i >= 0; i--) {
      swap(array, 0, i);
      maxHeapify(array, 0, i);
    }
  }

  private int left(int i) {
    return 2 * i + 1;
  }

  private int right(int i) {
    return 2 * i + 2;
  }
}
