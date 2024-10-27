package ru.vspochernin.model;

import java.util.List;

public class Student {

    private final String name;
    private final String group;
    private int course;
    private final List<Integer> marks;

    public Student(String name, String group, int course, List<Integer> marks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }

    public int getCourse() {
        return course;
    }

    public void toTheNextCourse() {
        this.course += 1;
    }

    public double getAverageMark() {
        return marks.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", marks=" + marks +
                ", averageMark=" + getAverageMark() +
                '}';
    }
}
