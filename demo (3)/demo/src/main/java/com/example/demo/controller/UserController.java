package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User createUser (@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById (@PathVariable Long id) {
        return userService.getUserById(id).orElse( null);
    }

    @PutMapping("/{id}")
    public User updateDataById (@PathVariable Long id,@RequestBody User updatedUser) {
        return userService.updateDataById(id, updatedUser).orElse(null);
    }
}
