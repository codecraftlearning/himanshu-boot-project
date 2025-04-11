package com.codecraft.java.services;

import com.codecraft.java.Repositories.UserRepository;
import com.codecraft.java.components.UserRequestHandler;
import com.codecraft.java.components.UserResponseHandler;
import com.codecraft.java.entities.User;
import com.codecraft.java.models.UserRequest;
import com.codecraft.java.models.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserResponseHandler userResponseHandler;

    @Autowired
    private UserRequestHandler userRequestHandler;

    public UserResponse createUser(UserRequest request) throws Error{
        List<String> errors = userRequestHandler.validateRequest(request);
        if (!errors.isEmpty()) {
            throw  new Error(errors.toString());
        }

        User user = userRequestHandler.createUser(request);
        User savedUser = userRepository.save(user);

        return  userResponseHandler.createResponse(savedUser);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> userResponseHandler.createResponse(user)).collect(Collectors.toList());
    }

    public UserResponse getUserById(Integer id) throws Error {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Error("User Does not exists");
        }
        return userResponseHandler.createResponse(user.get());
    }

    public UserResponse getUserByEmail(String email) throws Error {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new Error("User Does not exists");
        }
        return userResponseHandler.createResponse(user.get());
    }

    public List<UserResponse> getUsersByName(String name) throws Error {
        List<User> users = userRepository.findByNameContaining(name);
        return users.stream().map(user -> userResponseHandler.createResponse(user)).collect(Collectors.toList());
    }
}
