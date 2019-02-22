package ru.job4j.travel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест обработки профиля клиента
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ProfilesTest {
    /**
     * Проверка работы метода map Stream Api, получение списка адресов
     */
    @Test
    public void testStreamMap() {
        Profiles my = new Profiles();
        List<Profile> profiles = new ArrayList<>();
        Address adr1 = new Address("Izhevsk", "Kirova", 22, 12);
        Address adr2 = new Address("Moskow", "Lenina", 134, 56);
        profiles.add(new Profile("Ivan", adr1));
        profiles.add(new Profile("Alex", adr2));
        List<Address> expected = new ArrayList<>();
        expected.add(adr1);
        expected.add(adr2);
        List<Address> result = my.collect(profiles);
        assertThat(result, is(expected));
    }

    /**
     * Проверка работы метода distinct Stream Api, а также сортировки по полю sity
     */
    @Test
    public void testStreamMapSortDistinct() {
        Profiles my = new Profiles();
        List<Profile> profiles = new ArrayList<>();
        Address adr1 = new Address("Izhevsk", "Kirova", 22, 12);
        Address adr2 = new Address("Moskow", "Lenina", 134, 56);
        Address adr3 = new Address("Abakan", "Petrova", 14, 7);
        profiles.add(new Profile("Ivan", adr1));
        profiles.add(new Profile("Alex", adr2));
        profiles.add(new Profile("Petr", adr3));
        profiles.add(new Profile("Liza", adr1));
        profiles.add(new Profile("Masha", adr1));
        List<Address> expected = new ArrayList<>();
        expected.add(adr3);
        expected.add(adr1);
        expected.add(adr2);
        List<Address> result = my.collect(profiles);
        assertThat(result, is(expected));
    }
}