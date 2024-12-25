package org.ahad.reactive;

import java.util.stream.Stream;

public class StreamSources {

    public static Stream<String> stringNumbersStream() {
        return Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    }

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(2, "Vinicious", "Junior"),
                new User(4, "Lamine", "Yamal"),
                new User(5, "Jude", "Bellingham"),
                new User(6, "Neymar", "Junior")
        );
    }

}
