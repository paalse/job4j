package ru.job4j.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты выборки студентов
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class SchoolTest {
    @Test
    public void whenA() {
        School my = new School();
        Student st1 = new Student("Ivan", 10);
        Student st2 = new Student("Alex", 25);
        Student st3 = new Student("Mitr", 50);
        Student st4 = new Student("Tom", 75);
        Student st5 = new Student("John", 100);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        List<Student> expected = new ArrayList<>();
        expected.add(st4);
        expected.add(st5);
        List<Student> result = my.collect(students, student -> student.getScore() >= 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenB() {
        School my = new School();
        Student st1 = new Student("Ivan", 10);
        Student st2 = new Student("Alex", 25);
        Student st3 = new Student("Mitr", 50);
        Student st4 = new Student("Tom", 75);
        Student st5 = new Student("John", 100);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        List<Student> expected = new ArrayList<>();
        expected.add(st3);
        List<Student> result = my.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenC() {
        School my = new School();
        Student st1 = new Student("Ivan", 10);
        Student st2 = new Student("Alex", 25);
        Student st3 = new Student("Mitr", 50);
        Student st4 = new Student("Tom", 75);
        Student st5 = new Student("John", 100);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        List<Student> expected = new ArrayList<>();
        expected.add(st1);
        expected.add(st2);
        List<Student> result = my.collect(students, student -> student.getScore() < 50);
        assertThat(result, is(expected));
    }
}