package ru.vspochernin.exam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.vspochernin.exam.model.Country;
import ru.vspochernin.exam.model.User;
import ru.vspochernin.exam.repository.UserRepository;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("Alexey", 15, Country.RUSSIA));
            userRepository.save(new User("John", 30, Country.USA));
            userRepository.save(new User("Pierre", 14, Country.FRANCE));
            userRepository.save(new User("Hans", 40, Country.GERMANY));
            userRepository.save(new User("Hideo", 61, Country.JAPAN));
        };
    }
}
