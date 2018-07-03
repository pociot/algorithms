package com.pociot.sorting;

public class InsertionSort extends SortingAlgorithm {

    @Override
    public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
        int i = 1;
        while (i < array.length) {
            int j = i;
            while (j > 0 && array[j-1].compareTo(array[j]) > 0) {
                swap(array, j, j-1);
                j = j-1;
            }
            i++;
        }
        return array;
    }
}
