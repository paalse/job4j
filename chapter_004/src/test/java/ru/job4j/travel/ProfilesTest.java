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
}
