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
        List<User> users = new ArrayList<User>();
        users.add(new User("Alex", 25));
        users.add(new User("Petr", 5));
        users.add(new User("Ivan", 12));

        TreeSet<User> result = new TreeSet<User>(new SortUser().sort(users));
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
        List<User> users = new ArrayList<User>();
        users.add(row0);
        users.add(row1);
        users.add(row2);
        users.add(row3);
        List<User> expected = new ArrayList<User>();
        expected.add(row1);
        expected.add(row3);
        expected.add(row0);
        expected.add(row2);
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
        List<User> users = new ArrayList<User>();
        users.add(row0);
        users.add(row1);
        users.add(row2);
        users.add(row3);
        List<User> expected = new ArrayList<User>();
        expected.add(row2);
        expected.add(row0);
        expected.add(row3);
        expected.add(row1);
        List<User> result = new SortUser().sortByAllFields(users);
        assertThat(result, is(expected));
    }
}