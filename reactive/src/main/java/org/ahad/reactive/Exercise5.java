package org.ahad.reactive;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Simulate terminal events
        ReactiveSources.userFluxWithError().subscribe(
                System.out::println,
                System.out::println,
                () -> System.out.println("Complete")
        );
        System.out.println("Press a key to end");
        System.in.read();
    }

}