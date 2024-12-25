package org.ahad.reactive;

import java.io.IOException;

public class ObserverExercise {

    public static void main(String[] args) throws IOException {

        ReactiveSources.trumpsTweet().subscribe(s -> {
            System.out.println("Ahad's phone: " + s);
        });

        ReactiveSources.trumpsTweet().subscribe(s -> {
            System.out.println("Ali's phone: " + s);
        });


        System.out.println("Press a key to end");
        System.in.read();
    }

}
