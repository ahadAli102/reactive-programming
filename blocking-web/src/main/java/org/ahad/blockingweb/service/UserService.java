package org.ahad.blockingweb.service;

import org.ahad.blockingweb.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(String userId) {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new User(userId, "Ahad", "ahad@gmail.com");
    }
}
