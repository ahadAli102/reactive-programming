package org.ahad.nonblockingweb.controller;


import org.ahad.nonblockingweb.model.User;
import org.ahad.nonblockingweb.model.UserPreferences;
import org.ahad.nonblockingweb.service.UserPreferencesService;
import org.ahad.nonblockingweb.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
    public Mono<User> getUser(@PathVariable("userId") String userId) {
        Mono<User> user = userService.getUser(userId);
        Mono<UserPreferences> userPreferences = userPreferencesService.getUserPreferences(userId);
        return user.zipWith(userPreferences, (u, up) -> {
            u.setUserPreferences(up);
            return u;
        });
    }
}
