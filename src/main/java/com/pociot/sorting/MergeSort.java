package com.pociot.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class MergeSort implements SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(@NotNull T[] array) {
    int n = array.length;
    if (n <= 1) {
      return array;
    }

    @SuppressWarnings("unchecked") T[] left = (T[]) Array
        .newInstance(array.getClass().getComponentType(), 0);
    @SuppressWarnings("unchecked") T[] right = (T[]) Array
        .newInstance(array.getClass().getComponentType(), 0);
    for (int i = 0; i < n; i++) {
      if (i < (n / 2)) {
        left = add(left, array[i]);
      } else {
        right = add(right, array[i]);
      }
    }

    left = sort(left);
    right = sort(right);

    return merge(left, right);
  }

  private <T extends Number & Comparable<? super T>> T[] merge(T[] left, T[] right) {
    T[] tempLeft = Arrays.copyOf(left, left.length);
    T[] tempRight = Arrays.copyOf(right, right.length);
    @SuppressWarnings("unchecked") T[] result = (T[]) Array
        .newInstance(left.getClass().getComponentType(), 0);
    while (getLength(tempLeft) != 0 && getLength(tempRight) != 0) {
      if (tempLeft[0].compareTo(tempRight[0]) <= 0) {
        result = add(result, tempLeft[0]);
        tempLeft = removeFirst(tempLeft);
      } else {
        result = add(result, tempRight[0]);
        tempRight = removeFirst(tempRight);
      }
    }

    while (getLength(tempLeft) != 0) {
      result = add(result, tempLeft[0]);
      tempLeft = removeFirst(tempLeft);
    }
    while (getLength(tempRight) != 0) {
      result = add(result, tempRight[0]);
      tempRight = removeFirst(tempRight);
    }
    return result;
  }

  private <T> T[] add(T[] array, T element) {
    Object newArray = getNewArrayPlusOne(array);
    //noinspection SuspiciousSystemArraycopy
    System.arraycopy(array, 0, newArray, 0, array.length);
    Array.set(newArray, getLength(newArray) - 1, element);
    //noinspection unchecked
    return (T[]) newArray;
  }

  @NotNull <T> Object getNewArrayPlusOne(T[] array) {
    return Array.newInstance(array.getClass().getComponentType(), array.length + 1);
  }

  private <T> T[] removeFirst(@NotNull T[] array) {
    return Arrays.copyOfRange(array, 1, array.length);
  }

  int getLength(Object array) {
    return array == null ? 0 : Array.getLength(array);
  }
}
