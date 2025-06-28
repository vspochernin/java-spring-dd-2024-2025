package ru.vspochernin.lab4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.vspochernin.lab4.model.User;
import ru.vspochernin.lab4.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
