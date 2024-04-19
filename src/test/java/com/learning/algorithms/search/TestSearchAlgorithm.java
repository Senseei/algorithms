package com.learning.algorithms.search;

import java.util.Random;

public class TestSearchAlgorithm {

    public static final int ARRAY_LENGTH = 100000000;
    public static final Random RAND = new Random();
    public static final int TIMES = 100;

    public static void main(String[] args) {
        System.out.println("-- Testing search algorithms --");
        System.out.println("-- Array length: " + ARRAY_LENGTH);

        testAverageTime(new BinarySearch(), "Binary Search", TIMES);
        testAverageTime(new LinearSearch(), "Linear Search", TIMES);
    }
    
    public static void testAverageTime(SearchAlgorithm algorithm, String algorithmName, int times) {
        System.out.println("Testing " + algorithmName + "...");

        Integer[] array = new Integer[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        double totalTime = 0.0;
        int elementsFound = 0;
        for (int i = 0; i < times; i++) {
            long startTime = System.currentTimeMillis();
            if (algorithm.search(array, RAND.nextInt(ARRAY_LENGTH)) >= 0)
                elementsFound++;
            long endTime = System.currentTimeMillis();
            double timeTaken = (endTime - startTime) / 1000.0;
            totalTime += timeTaken;
        }

        System.out.println(" - " + elementsFound + " elements found of " + times + " attempts");
        System.out.println(" - Average time: " + String.format("%.3f", totalTime / times) + " seconds");
    }
}
