package ru.vspochernin.collection;

import java.util.List;

import ru.vspochernin.model.Student;

/**
 * @author pochernin-vla
 */
public class StudentCollection {

    private static final double EPS = 10E-6;
    private static final double THRESHOLD_MARK = 3.0;

    private List<Student> students;

    public StudentCollection(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void toTheNextCourse() {
        students = students.stream()
                .filter(student -> student.getAverageMark() + EPS > THRESHOLD_MARK)
                .toList();
        students.forEach(Student::toTheNextCourse);
    }
}
