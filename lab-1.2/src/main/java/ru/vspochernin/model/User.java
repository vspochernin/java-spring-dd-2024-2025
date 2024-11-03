package ru.vspochernin.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String country;
}
