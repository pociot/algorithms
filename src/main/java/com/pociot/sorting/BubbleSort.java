package com.pociot.sorting;

public class BubbleSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    T[] returnArray = arrayCopyOf(array, array.length);
    for (int i = 0; i < returnArray.length - 1; i++) {
      for (int j = 0; j < returnArray.length - i - 1; j++) {
        if (returnArray[j].compareTo(returnArray[j + 1]) > 0) {
          swap(returnArray, j, j + 1);
        }
      }
    }
    return returnArray;
  }
}
