package com.backend_team.main_backend.services;

import com.backend_team.main_backend.models.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> userStore = new HashMap<>();

    /**
     * Registers a new user.
     *
     * @param username the username
     * @param password the password
     * @return true if registration is successful, false if the user already exists
     */
    public boolean registerUser(String username, String password) {
        if (userStore.containsKey(username)) {
            return false; // User already exists
        }

        // Password validation
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password does not meet the requirements.");
        }

        // Create and store new user
        User user = new User(username, password);
        userStore.put(username, user);
        return true;
    }

    /**
     * Authenticates a user.
     *
     * @param username the username
     * @param password the password
     * @return true if authentication is successful, false otherwise
     */
    public boolean authenticateUser(String username, String password) {
        User user = userStore.get(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    /**
     * Checks if the password meets security requirements.
     *
     * @param password the password
     * @return true if the password is valid, false otherwise
     */
    public boolean isValidPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }

        // Password must be at least 8 characters long and contain at least one digit and one special character
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * Checks if a username is available.
     *
     * @param username the username to check
     * @return true if the username is available, false otherwise
     */
    public boolean isUsernameAvailable(String username) {
        return !userStore.containsKey(username);
    }

    /**
     * Retrieves a user's information.
     *
     * @param username the username
     * @return the User object, or null if the user does not exist
     */
    public User getUser(String username) {
        return userStore.get(username);
    }

    /**
     * Deletes a user.
     *
     * @param username the username
     * @return true if the user was successfully deleted, false otherwise
     */
    public boolean deleteUser(String username) {
        return userStore.remove(username) != null;
    }

    /**
     * Updates a user's password.
     *
     * @param username    the username
     * @param newPassword the new password
     * @return true if the password was successfully updated, false otherwise
     */
    public boolean updatePassword(String username, String newPassword) {
        User user = userStore.get(username);
        if (user == null || !isValidPassword(newPassword)) {
            return false;
        }
        user.setPassword(newPassword);
        return true;
    }
}