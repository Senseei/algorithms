package com.learning.algorithms.sorting;

public interface SortingAlgorithm {
    public <T extends Comparable<T>> void sort(T[] array);
}
