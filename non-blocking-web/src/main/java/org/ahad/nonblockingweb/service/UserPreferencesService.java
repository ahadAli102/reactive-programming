package org.ahad.nonblockingweb.service;

import org.ahad.nonblockingweb.model.UserPreferences;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserPreferencesService {

    public Mono<UserPreferences> getUserPreferences(String userId) {
        return Mono.just(new UserPreferences(List.of("Laptop", "Internet")))
                .delayElement(java.time.Duration.ofSeconds(10));
    }
}
