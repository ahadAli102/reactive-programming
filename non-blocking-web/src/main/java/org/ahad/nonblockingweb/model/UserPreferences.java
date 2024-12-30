package org.ahad.nonblockingweb.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPreferences {
    private final List<String> preferences;

    public UserPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    @Override
    public String toString() {
        return "UserPreferences{" +
                "preferences=" + preferences +
                '}';
    }
}
