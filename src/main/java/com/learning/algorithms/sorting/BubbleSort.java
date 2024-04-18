package com.learning.algorithms.sorting;

public class BubbleSort implements SortingAlgorithm {
    
    public <T extends Comparable<T>> void sort(T[] array) {
        int changes;
        do {
            changes = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (((Comparable<T>)array[i]).compareTo(array[i+1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;

                    changes++;
                }
            }
        } while (changes > 0);
    }
}
