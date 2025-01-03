package org.ahad.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveSources {
    public static Flux<String> stringNumbersFlux() {
        return Flux.just("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFlux() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFluxWithException() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> {
                    if (e == 5) throw new RuntimeException("An error happened in the flux");
                    return e;
                });
    }

    public static Mono<Integer> intNumberMono() {
        return Mono.just(42)
                .delayElement(Duration.ofSeconds(1));
    }

    public static Flux<User> userFlux() {
        return Flux.just(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(2, "Diego", "Maradona"),
                new User(4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Klinsmann"),
                new User(6, "Gareth", "Bale")
        ).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<User> userMonoWithError() {
        return Mono.just(
                new User(1, "Lionel", "Messi")
        ).map(u -> {
            if (u.getId() == 1) {
                throw new RuntimeException("Exception occured inside ");
            } else {
                return u;
            }
        }).delayElement(Duration.ofSeconds(1));
    }

    public static Flux<User> userFluxWithError() {
        return Flux.just(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(2, "Diego", "Maradona"),
                new User(4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Klinsmann"),
                new User(6, "Gareth", "Bale")
        ).map(u -> {
            if (u.getId() == 4) {
                throw new RuntimeException("Exception occured inside ");
            } else {
                return u;
            }
        }).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<User> userMono() {
        return Mono.just(
                new User(1, "Lionel", "Messi")
        ).delayElement(Duration.ofSeconds(1));

    }

    public static Flux<String> unresponsiveFlux() {
        return Flux.never();
    }

    public static Mono<String> unresponsiveMono() {
        return Mono.never();
    }

    public static Flux<Integer> intNumbersFluxWithRepeat() {
        return Flux
                .just(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<String> trumpsTweet() {
        return Flux.just(
                "Make America great again",
                "We will put 10% extra tariff on Chiness products",
                "Joe Biden is the worst president in American history",
                "We have a job to do",
                "You can't let her win"
        ).delayElements(Duration.ofSeconds(1));
    }

}
