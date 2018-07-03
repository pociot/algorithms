package com.pociot.sorting;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class MergeSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    int n = array.length;
    if (n <= 1)
      return array;

    T[] left = (T[]) new Number[0];
    T[] right = (T[]) new Number[0];

    for (int i = 0; i < n; i++) {
      if (i < (n / 2))
        left = ArrayUtils.add(left, array[i]);
      else
        right = ArrayUtils.add(right, array[i]);
    }
    left = sort(left);
    right = sort(right);

    return merge(left, right);
  }

  private <T extends Number & Comparable<? super T>>T[] merge(T[] left, T[] right) {
    T[] tempLeft = Arrays.copyOf(left, left.length);
    T[] tempRight = Arrays.copyOf(right, right.length);
    T[] result = (T[]) new Number[0];
    System.out.println();
    while (!ArrayUtils.isEmpty(tempLeft) && !ArrayUtils.isEmpty(tempRight)) {
      if(tempLeft[0].compareTo(tempRight[0]) <= 0) {
        result = ArrayUtils.add(result, tempLeft[0]);
        tempLeft = ArrayUtils.remove(tempLeft, 0);
      } else {
        result = ArrayUtils.add(result, tempRight[0]);
        tempRight = ArrayUtils.remove(tempRight, 0);
      }
    }

    while (!ArrayUtils.isEmpty(tempLeft)) {
      result = ArrayUtils.add(result, tempLeft[0]);
      tempLeft = ArrayUtils.remove(tempLeft, 0);
    }
    while (!ArrayUtils.isEmpty(tempRight)) {
      result = ArrayUtils.add(result, tempRight[0]);
      tempRight = ArrayUtils.remove(tempRight, 0);
    }
    return result;
  }
}
