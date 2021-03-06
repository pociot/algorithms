package com.pociot.sorting;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class InsertionSort implements SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(@NotNull T[] array) {
    T[] returnArray = Arrays.copyOf(array, array.length);
    int i = 1;
    while (i < returnArray.length) {
      int j = i;
      while (j > 0 && returnArray[j - 1].compareTo(returnArray[j]) > 0) {
        swap(returnArray, j, j - 1);
        j = j - 1;
      }
      i++;
    }
    return returnArray;
  }
}
