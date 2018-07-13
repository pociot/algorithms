package com.pociot.sorting;

public class CombSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    int n = array.length;

    int gap = n;

    boolean swapped = true;

    while (gap != 1 || swapped) {
      gap = getNextGap(gap);
      swapped = false;
      for (int i = 0; i < n - gap; i++) {
        if (array[i].compareTo(array[i + gap]) > 0) {
          swap(array, i, i + gap);
          swapped = true;
        }
      }
    }

    return array;
  }

  private int getNextGap(int gap) {
    gap = (gap * 10) / 13;
    if (gap < 1)
      return 1;
    return gap;
  }
}
