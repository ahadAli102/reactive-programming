package org.ahad.reactive;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Print value from ReactiveSources.intNumberMono()
        ReactiveSources.intNumberMono().subscribe(System.out::println);
        Integer n = ReactiveSources.intNumberMono().block();

        System.out.println("Number is: " + n);
        System.out.println("Press a key to end");
        System.in.read();
    }

}