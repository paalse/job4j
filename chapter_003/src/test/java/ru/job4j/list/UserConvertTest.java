package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест конвертации List в Map
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class UserConvertTest {

    @Test
    public void listToHashMapTest() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Alex", "Izhevsk"));
        users.add(new User(2, "Petr", "Moskow"));
        users.add(new User(3, "Ivan", "Perm"));
        HashMap<Integer, User> result = new HashMap<Integer, User>(new UserConvert().process(users));
        assertThat(result.get(2).getName(), is("Petr"));
    }
}