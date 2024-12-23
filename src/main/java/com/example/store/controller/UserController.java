package com.example.store.controller;

import com.example.store.model.UserDemo;
import com.example.store.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDemo createUser(@RequestBody UserDemo userDemo) {
        System.out.println("[userDemo]: " + userDemo);
        return userService.createUser(userDemo);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<UserDemo> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDemo getUserByID(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
