package org.ahad.nonblockingweb.service;

import org.springframework.stereotype.Service;
import org.ahad.nonblockingweb.model.User;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UserService {

    public Mono<User> getUser(String userId) {
        return Mono.just(new User(userId, "Ahad", "ahad@gmail.com"))
                .delayElement(Duration.ofSeconds(5));
    }
}
