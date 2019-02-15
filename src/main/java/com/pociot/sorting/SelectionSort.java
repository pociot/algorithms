package com.pociot.sorting;

import org.jetbrains.annotations.NotNull;

public class SelectionSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(@NotNull T[] array) {
    T[] returnArray = arrayCopyOf(array, array.length);
    for (int j = 0; j < returnArray.length - 1; j++) {
      int iMin = j;
      for (int i = j + 1; i < returnArray.length; i++) {
        if (returnArray[i].compareTo(returnArray[iMin]) < 0) {
          iMin = i;
        }
      }
      if (iMin != j) {
        swap(returnArray, j, iMin);
      }
    }
    return returnArray;
  }
}
