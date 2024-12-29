package org.ahad.blockingweb.service;

import org.ahad.blockingweb.model.UserPreferences;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferencesService {

    public UserPreferences getUserPreferences(String userId) {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new UserPreferences(List.of("Laptop", "Internet"));
    }
}
