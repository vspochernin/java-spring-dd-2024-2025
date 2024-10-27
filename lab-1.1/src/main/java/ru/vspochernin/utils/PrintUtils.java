package ru.vspochernin.utils;

import java.util.List;

import ru.vspochernin.model.Student;

/**
 * @author pochernin-vla
 */
public class PrintUtils {

    private PrintUtils() {
    }

    public static void printStudents(List<Student> students) {
        students.forEach(System.out::println);
    }

    public static void printStudents(List<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(System.out::println);
    }
}
