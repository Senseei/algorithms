package com.learning.algorithms.sorting;

public class TestSortingAlgorithm {
    
    public static void main(String[] args) {
        test(new MergeSort(), "Merge Sort");
        test(new HeapSort(), "Heap Sort");
        test(new SelectionSort(), "Selection Sort");
        test(new BubbleSort(), "Bubble Sort");
    }

    public static void test(SortingAlgorithm algorithm, String algorithmName) {
        int length = 100000; // Replace with your desired array length

        // Generate best case array (sorted in ascending order)
        Integer[] bestCaseArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            bestCaseArray[i] = i;
        }

        // Generate worst case array (sorted in descending order)
        Integer[] worstCaseArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            worstCaseArray[i] = length - i - 1;
        }

        // Sort best case array and print time taken
        long startTime = System.currentTimeMillis();
        algorithm.sort(bestCaseArray);
        long endTime = System.currentTimeMillis();
        double timeTaken = (endTime - startTime) / 1000.0;
        System.out.println(algorithmName + " - Best case time: " + timeTaken + " seconds");

        // Sort worst case array and print time taken
        startTime = System.currentTimeMillis();
        algorithm.sort(worstCaseArray);
        endTime = System.currentTimeMillis();
        timeTaken = (endTime - startTime) / 1000.0;
        System.out.println(algorithmName + " - Worst case time: " + timeTaken + " seconds");
    }
}