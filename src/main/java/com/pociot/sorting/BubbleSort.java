package com.pociot.sorting;

public class BubbleSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if(array[j].compareTo(array[j + 1])  > 0) {
          swap(array, j, j + 1);
        }
      }
    }
    return array;
  }
}
