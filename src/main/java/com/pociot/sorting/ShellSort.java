package com.pociot.sorting;

public class ShellSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    for (int gap = array.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < array.length; i++) {
        T temp = array[i];
        int j;
        for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
          array[j] = array[j - gap];
        }
        array[j] = temp;
      }
    }
    return array;
  }
}
