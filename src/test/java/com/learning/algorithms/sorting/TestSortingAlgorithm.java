package com.learning.algorithms.sorting;

public class TestSortingAlgorithm {

    private static final int ARRAY_LENGTH = 100000;
    
    public static void main(String[] args) {
        int times = 10; // Replace with your desired number of times to run the test
        testAverageTime(new MergeSort(), "Merge Sort", times);
        testAverageTime(new HeapSort(), "Heap Sort", times);
        testAverageTime(new QuickSort(), "Quick Sort", times);
        testAverageTime(new SelectionSort(), "Selection Sort", times);
        testAverageTime(new BubbleSort(), "Bubble Sort", times);
    }

    public static void test(SortingAlgorithm algorithm, String algorithmName) {
        // Generate best case array (sorted in ascending order)
        Integer[] bestCaseArray = new Integer[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            bestCaseArray[i] = i;
        }

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
                    // Generate best case array (sorted in ascending order)
            Integer[] bestCaseArray = new Integer[ARRAY_LENGTH];
            for (int i = 0; i < ARRAY_LENGTH; i++) {
                bestCaseArray[i] = i;
            }

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