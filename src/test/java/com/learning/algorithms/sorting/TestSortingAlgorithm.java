package com.learning.algorithms.sorting;

public class TestSortingAlgorithm {
    
    public static void main(String[] args) {
        int times = 10; // Replace with your desired number of times to run the test
        testAverageTime(new SelectionSort(), "Selection Sort", times);
        testAverageTime(new BubbleSort(), "Bubble Sort", times);
        testAverageTime(new MergeSort(), "Merge Sort", times);
        testAverageTime(new HeapSort(), "Heap Sort", times);
        testAverageTime(new QuickSort(), "Quick Sort", times);
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

    public static void testAverageTime(SortingAlgorithm algorithm, String algorithmName, int times) {
        int length = 100000; // Replace with your desired array length

        double bestCaseTotalTime = 0;
        double worstCaseTotalTime = 0;

        for (int t = 0; t < times; t++) {
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
            bestCaseTotalTime += timeTaken;

            // Sort worst case array and print time taken
            startTime = System.currentTimeMillis();
            algorithm.sort(worstCaseArray);
            endTime = System.currentTimeMillis();
            timeTaken = (endTime - startTime) / 1000.0;
            worstCaseTotalTime += timeTaken;
        }

        System.out.println(algorithmName + " - Best case average time: " + bestCaseTotalTime / times + " seconds");
        System.out.println(algorithmName + " - Worst case average time: " + worstCaseTotalTime / times + " seconds");
    }
}