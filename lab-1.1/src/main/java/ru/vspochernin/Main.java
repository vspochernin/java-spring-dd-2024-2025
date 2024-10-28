package ru.vspochernin;

import java.util.List;

import ru.vspochernin.collection.StudentCollection;
import ru.vspochernin.model.Student;
import ru.vspochernin.utils.PrintUtils;

/**
 * @author pochernin-vla
 */
public class Main {

    public static void main(String[] args) {
        StudentCollection studentCollection =
                new StudentCollection(List.of(
                        new Student("Имя1", "Группа1", 3, List.of(1, 2, 3, 3, 3)),
                        new Student("Имя2", "Группа1", 3, List.of(2, 2, 3, 3, 5)),
                        new Student("Имя3", "Группа2", 4, List.of(3, 3, 3, 4, 5)),
                        new Student("Имя4", "Группа2", 4, List.of(2, 2, 4, 2, 3)),
                        new Student("Имя5", "Группа2", 4, List.of(5, 5, 5, 5, 5)),
                        new Student("Имя6", "Группа3", 1, List.of())));

        System.out.println("Студенты до перевода на следующий курс:");
        PrintUtils.printStudents(studentCollection.getStudents());
        System.out.println();

        studentCollection.toTheNextCourse();

        System.out.println("Студенты после перевода на следующий курс:");
        PrintUtils.printStudents(studentCollection.getStudents());
        System.out.println();

        System.out.println("Студенты 5-го курса:");
        PrintUtils.printStudents(studentCollection.getStudents(), 5);
        System.out.println();
    }
}