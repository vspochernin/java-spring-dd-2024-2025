package ru.vspochernin.utils;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import ru.vspochernin.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserUtilsTest {

    private static final List<User> USERS = List.of(
            new User(1L, "John", "Lennon", 40, "UK"),
            new User(2L, "David", "Gilmour", 78, "UK"),
            new User(3L, "Jimmy", "Page", 80, "UK"),
            new User(4L, "Elvis", "Presley", 42, "USA"),
            new User(5L, "Dmitri", "Hvorostovsky", 55, "RU"));
    private static final double EPS = 0.001;

    @Test
    public void givenUsers_whenGetUsersSortedByLastName_thenReturnCorrectList() {
        List<User> sortedByLastName = UserUtils.getUsersSortedByLastName(USERS);

        List<Long> expectedOrder = List.of(2L, 5L, 1L, 3L, 4L);
        List<Long> actualOrder = sortedByLastName.stream().map(User::getId).toList();

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void givenUsers_whenGetUsersSortedByAge_thenReturnCorrectList() {
        List<User> sortedByAge = UserUtils.getUsersSortedByAge(USERS);

        List<Long> expectedOrder = List.of(1L, 4L, 5L, 2L, 3L);
        List<Long> actualOrder = sortedByAge.stream().map(User::getId).toList();

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void givenUsersOlderThan7_whenIsAllUsersOlderThan7_thenReturnTrue() {
        boolean expected = true;
        boolean actual = UserUtils.isAllUsersOlderThan7(USERS);

        assertEquals(expected, actual);
    }

    @Test
    public void givenUsersWithUserNoOlderThan7_whenIsAllUsersOlderThan7_thenReturnFalse() {
        List<User> usersWithUserNoOlderThan7 =
                Stream.concat(USERS.stream(), Stream.of(new User(6L, "Young", "Boy", 7, "CN"))).toList();

        boolean expected = false;
        boolean actual = UserUtils.isAllUsersOlderThan7(usersWithUserNoOlderThan7);

        assertEquals(expected, actual);
    }

    @Test
    public void givenUsers_whenGetAverageAge_thenReturnCorrectValue() {
        double expected = 59;
        double actual = UserUtils.getAverageAge(USERS);

        assertTrue(Math.abs(expected - actual) < EPS);
    }

    @Test
    public void givenUsers_whenGetDistinctCountriesCount_thenReturnCorrectValue() {
        long expected = 3L;
        long actual = UserUtils.getDistinctCountriesCount(USERS);

        assertEquals(expected, actual);
    }
}