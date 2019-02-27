package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Телефонный справочник
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        var result = new ArrayList<Person>();

        for (var value : this.persons) {
            if ((value.getName().toLowerCase().contains(key.toLowerCase()))
                    || (value.getSurname().toLowerCase().contains(key.toLowerCase()))
                    || (value.getAddress().toLowerCase().contains(key.toLowerCase()))
                    || (value.getPhone().toLowerCase().contains(key.toLowerCase()))) {
                result.add(value);
            }
        }
        return result;
    }
}