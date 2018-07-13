package com.pociot.sorting;

public class HeapSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    int n = array.length;

    for (int i = n / 2 - 1; i > 0; i--) {
      heapify(array, n, i);
    }

    for (int i = n-1; i > 0; i--) {
      swap(array, i, 0);
      heapify(array, i, 0);
    }
    return array;
  }

  private <T extends Number & Comparable<? super T>> void heapify(T[] array, int n, int i) {
    int maxIndex = i;
    int leftIndex = 2 * i + 1;
    int rightIndex = 2 * i + 2;

    if (leftIndex < n && array[leftIndex].compareTo(array[maxIndex]) > 0) {
      maxIndex = leftIndex;
    }

    if (rightIndex < n && array[rightIndex].compareTo(array[maxIndex]) > 0) {
      maxIndex = rightIndex;
    }

    if (maxIndex != i) {
      swap(array, i, maxIndex);
      heapify(array, n, maxIndex);
    }
  }
}
