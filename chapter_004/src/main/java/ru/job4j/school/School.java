package ru.job4j.school;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс описывающий школу
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class School {
    /**
     * Метод позволяет выбрать группы студентов по оценкам
     *
     * @param students  - список студентов
     * @param predicate - лямбда-выражение для ограничения выборки
     * @return - выборка студентов отфильтрованная по ламбда-выражению
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}