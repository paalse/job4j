package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест сортировки
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class UserTest {
    @Test
    public void sortTest() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Alex", 25));
        users.add(new User("Petr", 5));
        users.add(new User("Ivan", 12));

        TreeSet<User> result = new TreeSet<User>( new SortUser().sort(users));
        assertThat(result.first().getAge(),is(5));
    }
}
