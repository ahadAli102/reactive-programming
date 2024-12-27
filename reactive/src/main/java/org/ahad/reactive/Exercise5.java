package org.ahad.reactive;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Simulate terminal events
        ReactiveSources.userFluxWithError().subscribe(
                System.out::println,
                System.out::println,
                () -> System.out.println("Complete")
        );

        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();

    }

}


class MySubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("On subscribe");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1);
    }
}