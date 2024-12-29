package org.ahad.blockingweb.controller;

import org.ahad.blockingweb.model.User;
import org.ahad.blockingweb.model.UserPreferences;
import org.ahad.blockingweb.service.UserPreferencesService;
import org.ahad.blockingweb.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserPreferencesService userPreferencesService;

    public UserController(UserService userService, UserPreferencesService userPreferencesService) {
        this.userService = userService;
        this.userPreferencesService = userPreferencesService;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        User user = userService.getUser(userId);
        UserPreferences userPreferences = userPreferencesService.getUserPreferences(userId);
        user.setUserPreferences(userPreferences);
        return user;
    }

    @GetMapping("/v2/{userId}")
    public User getUserV2(@PathVariable("userId") String userId) {
        CompletableFuture<User> userFuture = CompletableFuture.supplyAsync(
                () -> userService.getUser(userId)
        );
        CompletableFuture<UserPreferences> userPreferencesFuture = CompletableFuture.supplyAsync(
                () -> userPreferencesService.getUserPreferences(userId)
        );
        CompletableFuture<Void> bothFutures = CompletableFuture.allOf(userFuture, userPreferencesFuture);
        bothFutures.join();
        User user = userFuture.join();
        UserPreferences userPreferences = userPreferencesFuture.join();
        user.setUserPreferences(userPreferences);
        return user;
    }
}
