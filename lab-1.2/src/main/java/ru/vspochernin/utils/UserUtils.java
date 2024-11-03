package ru.vspochernin.utils;

import java.util.Comparator;
import java.util.List;

import ru.vspochernin.model.User;

/**
 * @author pochernin-vla
 */
public class UserUtils {

    public static void printUsersSortedByLastName(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);
    }

    public static void printUsersSortedByAge(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);
    }

    public static boolean isAllUsersOlderThan7(List<User> users) {
        return users.stream()
                .map(User::getAge)
                .allMatch(age -> age > 7);
    }

    public static double getAverageAge(List<User> users) {
        return users.stream()
                .map(User::getAge)
                .mapToInt(Integer::valueOf)
                .average().orElse(0.0);
    }

    public static void printDistinctCountriesCount(List<User> users) {
        System.out.println(users.stream()
                .map(User::getCountry)
                .distinct()
                .count());
    }
}
