package com.learning.algorithms.sorting;

import java.util.Random;

public class QuickSort implements SortingAlgorithm {

    private Random rand = new Random();
    
    public <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left >= right) return;

        int pivotIndex = left + rand.nextInt(right - left + 1);
        T pivot = array[pivotIndex];

        int lcursor = left;
        int rcursor = right;

        while (lcursor <= rcursor) {
            while (((Comparable<T>)array[lcursor]).compareTo(pivot) < 0)
                lcursor++;
            while (((Comparable<T>)array[rcursor]).compareTo(pivot) > 0)
                rcursor--;

            if (lcursor <= rcursor) {
                T temp = array[lcursor];
                array[lcursor] = array[rcursor];
                array[rcursor] = temp;
                lcursor++;
                rcursor--;
            }
        }

        quickSort(array, left, rcursor);
        quickSort(array, lcursor, right);
    }
}
