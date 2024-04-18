package com.learning.algorithms.sorting;

public class HeapSort implements SortingAlgorithm {
    
    public <T extends Comparable<T>> void sort(T[] array) {
        // First, build the initial max heap
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Then, extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private <T extends Comparable<T>> void heapify(T[] array, int size, int index) {
        int biggest = index;
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        if (leftChild < size && ((Comparable<T>)array[leftChild]).compareTo(array[biggest]) > 0)
            biggest = leftChild;
        if (rightChild < size && ((Comparable<T>)array[rightChild]).compareTo(array[biggest]) > 0)
            biggest = rightChild;
        
        if (biggest != index) {
            swap(array, index, biggest);
            heapify(array, size, biggest);
        }
    }

    private <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}