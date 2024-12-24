package com.ahad.imperative;

import java.util.ArrayList;
import java.util.List;

public class ImperativeProgramming {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> processedNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                processedNumbers.add(number * number);
            }
        }

        for (int result : processedNumbers) {
            System.out.println("Processed: " + result);
        }
        System.out.println("Processing complete!");
    }
}
