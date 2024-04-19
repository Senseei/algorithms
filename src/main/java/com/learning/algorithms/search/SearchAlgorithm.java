package com.learning.algorithms.search;

public interface SearchAlgorithm {
    public <T extends Comparable<T>> int search(T[] arr, T target);
}
