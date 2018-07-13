package com.pociot.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortingAlgorithmTest {

    private Integer[] table  = new Integer[10];
    private Integer[] sortedTable = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Before
    public void setUp() {
        table = new Integer[]{9, 7, 4, 1, 6, 2, 8, 3, 0, 5};
    }

    @Test
    public void insertionSortTest() {
        SortingAlgorithm sortingAlgorithm = new InsertionSort();
        Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    }

    @Test
    public void selectionSortTest() {
        SortingAlgorithm sortingAlgorithm = new SelectionSort();
        Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    }

    @Test
    public void mergeSortTest() {
        SortingAlgorithm sortingAlgorithm = new MergeSort();
        Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    }

    @Test
    public void heapSortTest() {
        SortingAlgorithm sortingAlgorithm = new HeapSort();
        Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    }

    @Test
    public void quickSortTest() {
        SortingAlgorithm sortingAlgorithm = new QuickSort();
        Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    }

    @Test
    public void bubbleSortTest() {
        SortingAlgorithm sortingAlgorithm = new BubbleSort();
        Assert.assertArrayEquals(sortedTable, sortingAlgorithm.sort(table));
    }
}
