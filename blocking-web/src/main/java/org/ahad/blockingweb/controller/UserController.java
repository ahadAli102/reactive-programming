package org.ahad.blockingweb.controller;

import org.ahad.blockingweb.model.User;
import org.ahad.blockingweb.model.UserPreferences;
import org.ahad.blockingweb.service.UserPreferencesService;
import org.ahad.blockingweb.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
