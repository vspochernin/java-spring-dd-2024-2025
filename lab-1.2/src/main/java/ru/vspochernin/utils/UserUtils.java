package ru.vspochernin.utils;

import java.util.Comparator;
import java.util.List;

import ru.vspochernin.model.User;

/**
 * @author pochernin-vla
 */
public class UserUtils {

    public static List<User> getUsersSortedByLastName(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .toList();
    }

    public static List<User> getUsersSortedByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList();
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

    public static long getDistinctCountriesCount(List<User> users) {
        return users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
    }
}
