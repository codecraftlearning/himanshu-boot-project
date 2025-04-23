package com.codecraft.java.controller;

import com.codecraft.java.models.UserRequest;
import com.codecraft.java.models.UserResponse;
import com.codecraft.java.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping (path = "/{id}")
    public  UserResponse getUser(@PathVariable(name = "id") Integer id) throws Error {
        return userService.getUserById(id);
    }

    @GetMapping (path = "/email/{email}")
    public UserResponse getUser(@PathVariable(name = "email") String email) throws Error {
        return userService.getUserByEmail(email);
    }

    @GetMapping (path = "/all")
    public List<UserResponse> getUserByName(@RequestParam (name = "name") String name) throws Error {
        return userService.getUsersByName(name);
    }
}
