package com.ahad.imperative;

import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

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

    /*@GetMapping("/{userId}")
    public Mono<User> getUserDetails(@PathVariable String userId) {
        Mono<User> userMono = Mono.fromCallable(() -> usersService.getUser(userId));
        Mono<UserPreferences> preferencesMono = Mono.fromCallable(() -> userPreferencesService.getPreference(userId));
        return userMono.zipWith(preferencesMono, (user, preferences) -> {
            user.setUserPreferences(preferences);
            return user;
        });
    }*/

}
