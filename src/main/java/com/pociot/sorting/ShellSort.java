package com.pociot.sorting;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class ShellSort implements SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(@NotNull T[] array) {
    T[] returnArray = Arrays.copyOf(array, array.length);
    for (int gap = returnArray.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < returnArray.length; i++) {
        T temp = returnArray[i];
        int j;
        for (j = i; j >= gap && returnArray[j - gap].compareTo(temp) > 0; j -= gap) {
          returnArray[j] = returnArray[j - gap];
        }
        returnArray[j] = temp;
      }
    }
    return returnArray;
  }
}
