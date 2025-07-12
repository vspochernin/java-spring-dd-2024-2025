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
            userRepository.save(User.builder()
                    .firstName("Alexey")
                    .age(25)
                    .country(Country.RUSSIA)
                    .build());
            userRepository.save(User.builder()
                    .firstName("John")
                    .age(30)
                    .country(Country.USA)
                    .build());
            userRepository.save(User.builder()
                    .firstName("Pierre")
                    .age(14)
                    .country(Country.FRANCE)
                    .build());
            userRepository.save(User.builder()
                    .firstName("Hans")
                    .age(40)
                    .country(Country.GERMANY)
                    .build());
            userRepository.save(User.builder()
                    .firstName("Li")
                    .age(18)
                    .country(Country.JAPAN)
                    .build());
        };
    }
}
