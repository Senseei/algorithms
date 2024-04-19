package com.learning.algorithms.search;

public class LinearSearch implements SearchAlgorithm {
    
    public <T extends Comparable<T>> int search(T[] arr, T target) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(target))
                return i;
        }
        return -1;
    }
}
