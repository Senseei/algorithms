package com.learning.algorithms.search;

public class BinarySearch implements SearchAlgorithm {

    public <T extends Comparable<T>> int search(T[] arr, T target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> int search(T[] array, T target, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (array[mid].equals(target))
            return mid;
        else if (target.compareTo(array[mid]) > 0)
            return search(array, target, mid + 1, right);
        else
            return search(array, target, left, mid - 1);
    }
}
