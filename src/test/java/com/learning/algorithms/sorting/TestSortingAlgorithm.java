package com.learning.algorithms.sorting;

public class TestSortingAlgorithm {

    private static final int ARRAY_LENGTH = 100000;
    private static final int TIMES = 10;
    private static Integer[] bestCaseArray = new Integer[ARRAY_LENGTH];
    
    public static void main(String[] args) {
        System.out.println("-- Testing sorting algorithms --");
        System.out.println("Array length: " + ARRAY_LENGTH);

        for (int i = 0; i < ARRAY_LENGTH; i++)
            bestCaseArray[i] = i;

        testAverageTime(new MergeSort(), "Merge Sort", TIMES);
        testAverageTime(new HeapSort(), "Heap Sort", TIMES);
        testAverageTime(new QuickSort(), "Quick Sort", TIMES);
        testAverageTime(new SelectionSort(), "Selection Sort", TIMES);
        testAverageTime(new BubbleSort(), "Bubble Sort", TIMES);
    }

    public static void test(SortingAlgorithm algorithm, String algorithmName) {

        // Generate worst case array (sorted in descending order)
        Integer[] worstCaseArray = new Integer[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            worstCaseArray[i] = ARRAY_LENGTH - i - 1;
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

    public static void testAverageTime(SortingAlgorithm algorithm, String algorithmName, int times) {
        System.out.println("Testing " + algorithmName + "...");

        double bestCaseTotalTime = 0;
        double worstCaseTotalTime = 0;

        for (int t = 0; t < times; t++) {

            // Generate worst case array (sorted in descending order)
            Integer[] worstCaseArray = new Integer[ARRAY_LENGTH];
            for (int i = 0; i < ARRAY_LENGTH; i++) {
                worstCaseArray[i] = ARRAY_LENGTH - i - 1;
            }

            // Sort best case array and print time taken
            long startTime = System.currentTimeMillis();
            algorithm.sort(bestCaseArray);
            long endTime = System.currentTimeMillis();
            double timeTaken = (endTime - startTime) / 1000.0;
            bestCaseTotalTime += timeTaken;

            // Sort worst case array and print time taken
            startTime = System.currentTimeMillis();
            algorithm.sort(worstCaseArray);
            endTime = System.currentTimeMillis();
            timeTaken = (endTime - startTime) / 1000.0;
            worstCaseTotalTime += timeTaken;
        }

        System.out.println(" - Best case average time: " + String.format("%.3f", bestCaseTotalTime / times) + " seconds");
        System.out.println(" - Worst case average time: " + String.format("%.3f", worstCaseTotalTime / times) + " seconds");
    }
}