package com.learning.algorithms.sorting;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println("Merge Sort");

        Integer[] array = { 12, 1 };

        sort(array);

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    private static <T> void sort(T[] array, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;

        sort(array, left, mid);
        sort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    @SuppressWarnings("unchecked")
    private static <T> void merge(T[] array, int left, int mid, int right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = left;

        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        T[] leftHalf = (T[]) new Object[leftLength];
        T[] rightHalf = (T[]) new Object[rightLength];

        for (int i = 0; i < leftLength; i++)
            leftHalf[i] = array[arrayIndex + i];
            
        for (int i = 0; i < rightLength; i++)
            rightHalf[i] = array[mid + i + 1];

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (((Comparable<T>)leftHalf[leftIndex]).compareTo(rightHalf[rightIndex]) <= 0) {
                array[arrayIndex] = leftHalf[leftIndex];
                leftIndex++;
            } else {
                array[arrayIndex] = rightHalf[rightIndex];
                rightIndex++;
            }
            arrayIndex++;
        }

        while (leftIndex < leftLength) {
            array[arrayIndex] = leftHalf[leftIndex];
            leftIndex++;
            arrayIndex++;
       }

       while (rightIndex < rightLength) {
            array[arrayIndex] = rightHalf[rightIndex];
            rightIndex++;
            arrayIndex++;
       }
    }
}