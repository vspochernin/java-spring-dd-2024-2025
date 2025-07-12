package ru.vspochernin.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vspochernin.exam.model.User;
import ru.vspochernin.exam.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/additional-info")
    public List<User> getByAge(@RequestParam Integer age) {
        return userService.getUsersByAgeGteSorted(age);
    }
}