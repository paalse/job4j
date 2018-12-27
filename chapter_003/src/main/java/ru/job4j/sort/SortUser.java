package ru.job4j.sort;

import java.util.*;

/**
 * Преобразование List в Set c сортировкой
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class SortUser {

    /**
     * Метод производит сортировку по полю age
     *
     * @param list - список для сортировки
     * @return - отсортированный список
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<User>();
        result.addAll(list);
        return result;
    }

    /**
     * Сортировка по длине имени.
     *
     * @return - отсортированный список
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
    }

    /**
     * Сортировка в лексикографическом порядке по имени и по возрасту
     *
     * @return - отсортированный список
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int flag = o1.getName().compareTo(o2.getName());
                return flag != 0 ? flag : o1.getAge().compareTo(o2.getAge());
            }
        });
        return list;
    }
}