package com.pociot.sorting;

public class SelectionSort extends SortingAlgorithm {

    @Override
    public <T extends Number & Comparable<? super T>> T[] sort(T[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            int iMin = j;
            for (int i = j+1; i < array.length; i++) {
                if(array[i].compareTo(array[iMin]) < 0)
                    iMin = i;
            }
            if(iMin != j)
                swap(array, j, iMin);
        }
        return array;
    }
}
