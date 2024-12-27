package org.ahad.reactive;

import java.io.IOException;
import java.time.Duration;

public class Exercise6 {

    public static void main(String[] args) throws IOException {

        String value = ReactiveSources.unresponsiveMono().block(Duration.ofMillis(10));

        System.out.println("Press a key to end");
        System.in.read();
    }

}