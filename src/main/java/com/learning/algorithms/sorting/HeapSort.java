package com.learning.algorithms.sorting;

public class HeapSort implements SortingAlgorithm {
    
    public <T extends Comparable<T>> void sort(T[] array) {
        for (int i = array.length; i > 0; i--) {
            heapify(array, i);
            swap(array, 0, i - 1);
        }
    }

    private <T extends Comparable<T>> void heapify(T[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(array, size, i);     
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

    @SuppressWarnings("unchecked")
    private <T> void swap(T[] array, int index1, int index2) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = (T) temp;
    }
}
