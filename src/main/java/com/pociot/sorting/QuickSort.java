package com.pociot.sorting;

public class QuickSort extends SortingAlgorithm {

  @Override
  public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
    lomutoSort(array, 0, array.length - 1);
    return array;
  }

  private <T extends Number & Comparable<? super T>> void lomutoSort(T[] array, int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);

      lomutoSort(array, low, pi-1);
      lomutoSort(array, pi+1, high);
    }
  }



  private <T extends Number & Comparable<? super T>> int partition(T[] array, int low, int high) {
    T pivot = array[high];
    int i = (low-1);
    for (int j=low; j<high; j++) {
      if (array[j].compareTo(pivot) <= 0) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i+1, high);
    return i+1;
  }
}
