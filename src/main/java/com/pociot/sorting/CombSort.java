package com.pociot.sorting;

public class CombSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    T[] returnArray = arrayCopyOf(array, array.length);
    int n = returnArray.length;

    int gap = n;

    boolean swapped = true;

    while (gap != 1 || swapped) {
      gap = getNextGap(gap);
      swapped = false;
      for (int i = 0; i < n - gap; i++) {
        if (returnArray[i].compareTo(returnArray[i + gap]) > 0) {
          swap(returnArray, i, i + gap);
          swapped = true;
        }
      }
    }

    return returnArray;
  }

  private int getNextGap(int gap) {
    gap = (gap * 10) / 13;
    if (gap < 1) {
      return 1;
    }
    return gap;
  }
}
