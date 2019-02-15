package com.pociot.sorting;

import java.lang.reflect.Array;
import org.jetbrains.annotations.NotNull;

interface SortingAlgorithm {

  <T extends Number & Comparable<? super T>> T[] sort(@NotNull T[] array);

  default <T extends Number & Comparable<? super T>> void swap(@NotNull T[] array, int i, int j) {
    T t = array[i];
    array[i] = array[j];
    array[j] = t;
  }

  default <T> T[] arrayCopyOf(T[] array, int length) {
    @SuppressWarnings("unchecked") T[] result = (T[]) Array
        .newInstance(array.getClass().getComponentType(), length);
    System.arraycopy(array, 0, result, 0, array.length);
    return result;
  }

}
