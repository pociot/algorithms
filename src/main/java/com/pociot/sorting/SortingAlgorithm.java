package com.pociot.sorting;

import org.jetbrains.annotations.NotNull;

interface SortingAlgorithm {

  <T extends Number & Comparable<? super T>> T[] sort(@NotNull T[] array);

  default <T extends Number & Comparable<? super T>> void swap(@NotNull T[] array, int i, int j) {
    T t = array[i];
    array[i] = array[j];
    array[j] = t;
  }
}
