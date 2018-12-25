package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Преобразование List в Set c сортировкой
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class SortUser {
    public Set<User> sort (List<User> list) {
        Set<User> result = new TreeSet<User>();
        result.addAll(list);
        return result;
    }
}
