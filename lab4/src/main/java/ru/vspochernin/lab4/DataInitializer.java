package ru.vspochernin.lab4;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vspochernin.lab4.model.Role;
import ru.vspochernin.lab4.model.User;
import ru.vspochernin.lab4.service.UserService;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) {
        if (userService.getAllUsers().isEmpty()) {
            userService.createUser(new User("Ivan", "Ivanov", Role.ADMIN));
            userService.createUser(new User("Petr", "Petrov", Role.DEVELOPER));
            userService.createUser(new User("Nikolay", "Nikolaev", Role.TESTER));
            userService.createUser(new User("Oleg", "Olegov", Role.SYSTEM_ANALYST));
            userService.createUser(new User("Kirill", "Kirillov", Role.TEAM_LEAD));
        }
    }
}
