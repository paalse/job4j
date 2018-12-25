package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Конвертация List в Map
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User element : list) {
            result.put(element.getId(), element);
        }
        return result;
    }
}