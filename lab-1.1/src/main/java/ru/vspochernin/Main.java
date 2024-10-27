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
                        new Student("Name1", "Group1", 3, List.of(1, 2, 3, 3, 3)),
                        new Student("Name2", "Group1", 3, List.of(2, 2, 3, 3, 5)),
                        new Student("Name3", "Group2", 4, List.of(3, 3, 3, 4, 5)),
                        new Student("Name4", "Group2", 4, List.of(4, 4, 4, 4, 5)),
                        new Student("Name5", "Group3", 5, List.of(5, 5, 5, 5, 5))));

        System.out.println("Students before next course");
        PrintUtils.printStudents(studentCollection.getStudents());
        System.out.println();

        studentCollection.toTheNextCourse();

        System.out.println("Students after next course");
        PrintUtils.printStudents(studentCollection.getStudents());
        System.out.println();

        System.out.println("Students on the 2 course");
        PrintUtils.printStudents(studentCollection.getStudents(), 5);
        System.out.println();
    }
}