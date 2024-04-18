package com.learning.algorithms.sorting;


public class SelectionSort implements SortingAlgorithm {
    
    public <T extends Comparable<T>> void sort(T[] array) {
        int smallestIndex = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (((Comparable<T>)array[j]).compareTo(array[smallestIndex]) < 0)
                    smallestIndex = j;
            }
            T temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
    }
}
