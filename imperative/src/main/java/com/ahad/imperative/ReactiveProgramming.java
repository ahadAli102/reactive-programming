package com.ahad.imperative;

import reactor.core.publisher.Flux;

public class ReactiveProgramming {
    public static void main(String[] args) {
        Flux<Integer> numberStream = Flux.just(1, 2, 3, 4, 5);

        numberStream
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .subscribe(
                        number -> System.out.println("Processed: " + number),
                        error -> System.err.println("Error: " + error),
                        () -> System.out.println("Processing complete!")
                );
    }
}
