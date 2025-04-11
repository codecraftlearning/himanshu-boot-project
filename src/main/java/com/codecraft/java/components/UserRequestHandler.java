package com.codecraft.java.components;

import com.codecraft.java.entities.User;
import com.codecraft.java.models.UserRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRequestHandler {

    public User createUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return user;
    }
    public List<String> validateRequest(UserRequest user) {
        List<String> errors = new ArrayList<>();

        if (user == null) {
            errors.add("UserRequest cannot be null");
            return errors;
        }

        String name = user.getName();
        if (name == null || name.trim().isEmpty()) {
            errors.add("Name is required");
        } else if (name.length() < 2 || name.length() > 50) {
            errors.add("Name must be between 2 and 50 characters");
        }

        String email = user.getEmail();
        if (email == null || email.trim().isEmpty()) {
            errors.add("Email is required");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            errors.add("Email format is invalid");
        }

        return errors;
    }
}
