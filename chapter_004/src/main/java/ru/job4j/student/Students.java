package ru.job4j.student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Обработка списка студентов
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Students {
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.getScope() - o1.getScope();
                    }
                })
                .takeWhile(x -> x.getScope() > bound)
                .collect(Collectors.toList());
    }
}
