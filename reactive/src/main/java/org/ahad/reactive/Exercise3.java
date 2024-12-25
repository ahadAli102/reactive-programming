package org.ahad.reactive;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Get all numbers in the ReactiveSources.intNumberFlux stream
        // into a list and print the list and it's size
        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList());
        System.out.println("List is: " + numbers);
    }

}