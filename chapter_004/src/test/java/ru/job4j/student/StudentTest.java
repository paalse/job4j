package ru.job4j.student;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тест обработки списка студентов
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class StudentTest {
    @Test
    public void whenScopeBig() {
        Students my = new Students();
        Student st1 = new Student("Ivan", 70);
        Student st2 = new Student("Alex", 25);
        Student st4 = new Student("Tom", 10);
        Student st3 = new Student("Mitr", 50);
        Student st5 = new Student("John", 100);
        Student st6 = new Student();
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        List<Student> result = my.levelOf(students, 50);
        List<Student> expected = new ArrayList<>();
        expected.add(st5);
        expected.add(st1);
        assertThat(result, is(expected));
    }
}