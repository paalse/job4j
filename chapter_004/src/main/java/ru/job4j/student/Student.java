package ru.job4j.student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Студент
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Student {
    private String name;
    private int scope;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", scope=" + scope
                + '}';
    }
}