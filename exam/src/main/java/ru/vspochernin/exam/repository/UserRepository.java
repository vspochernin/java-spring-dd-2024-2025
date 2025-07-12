package ru.vspochernin.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vspochernin.exam.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByAgeGreaterThanEqualOrderByFirstNameAsc(Integer age);
}