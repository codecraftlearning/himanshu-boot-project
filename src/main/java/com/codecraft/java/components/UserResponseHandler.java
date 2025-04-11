package com.codecraft.java.components;

import com.codecraft.java.entities.User;
import com.codecraft.java.models.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseHandler {

    public UserResponse createResponse(User user) {
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setSignature(this.toInitials(user.getName()));
        return response;
    }

    private String toInitials(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) return "";

        String[] parts = fullName.trim().split("\\s+");
        StringBuilder initials = new StringBuilder();

        for (String part : parts) {
            if (!part.isEmpty()) {
                initials.append(Character.toUpperCase(part.charAt(0))).append('.');
            }
        }

        return initials.toString();
    }
}
