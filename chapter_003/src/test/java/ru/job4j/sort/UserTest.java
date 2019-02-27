package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест сортировки
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class UserTest {

    /**
     * Тест сортировки по возрасту
     */
    @Test
    public void sortAgeTest() {
        List<User> users = List.of(
        new User("Alex", 25),
        new User("Petr", 5),
        new User("Ivan", 12));
        TreeSet<User> result = new TreeSet<>(new SortUser().sort(users));
        assertThat(result.first().getAge(), is(5));
    }

    /**
     * Тест сортировки по длине имени
     */
    @Test
    public void sortNameLengthTest() {
        User row0 = new User("Aleksey", 25);
        User row1 = new User("Ivan", 30);
        User row2 = new User("Aleksey", 20);
        User row3 = new User("Ivan", 25);
        List<User> users = new ArrayList<>(List.of(row0, row1, row2, row3));
        List<User> expected = List.of(row1, row3, row0, row2);
        List<User> result = new SortUser().sortNameLength(users);
        assertThat(result, is(expected));
    }

    /**
     * Тест сортировки по длине имени
     */
    @Test
    public void sortByAllFieldsTest() {
        User row0 = new User("Aleksey", 25);
        User row1 = new User("Ivan", 30);
        User row2 = new User("Aleksey", 20);
        User row3 = new User("Ivan", 25);
        List<User> users = new ArrayList<>(List.of(row0, row1, row2, row3));
        List<User> expected = List.of(row2, row0, row3, row1);
        List<User> result = new SortUser().sortByAllFields(users);
        assertThat(result, is(expected));
    }
}