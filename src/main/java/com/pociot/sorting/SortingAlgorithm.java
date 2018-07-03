package com.pociot.sorting;

import com.sun.istack.internal.NotNull;

abstract class SortingAlgorithm {
    @SuppressWarnings("FinalStaticMethod")
    static final <T extends Number & Comparable<? super T>> void swap(@NotNull T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public abstract <T extends Number & Comparable<? super T>>T[] sort(@NotNull T[] array);
}
