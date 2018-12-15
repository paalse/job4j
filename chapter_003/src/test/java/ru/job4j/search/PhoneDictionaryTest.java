package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты поиска данных по телефонному
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class PhoneDictionaryTest {

    /**
     * Тест поиска по полному имени
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    /**
     * Тест поиска по полной фамилии
     */
    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("Arsentev");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тест поиска по полному номеру телефона
     */
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("534872");
        assertThat(persons.iterator().next().getPhone(), is("534872"));
    }

    /**
     * Тест поиска по полному адресу
     */
    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("Bryansk");
        assertThat(persons.iterator().next().getAddress(), is("Bryansk"));
    }

    /**
     * Тест поиска по части имени
     */
    @Test
    public void whenFindByPartName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("etr");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    /**
     * Тест поиска по части фамилии
     */
    @Test
    public void whenFindByPartSurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("sen");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тест поиска по части номера телефона
     */
    @Test
    public void whenFindByPartPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("72");
        assertThat(persons.iterator().next().getPhone(), is("534872"));
    }

    /**
     * Тест поиска по части адреса
     */
    @Test
    public void whenFindByPartAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("Bry");
        assertThat(persons.iterator().next().getAddress(), is("Bryansk"));
    }

    /**
     * Тест поиска по имени без учета регистра
     */
    @Test
    public void whenFindByNameCaseSens() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("PeTr");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }

    /**
     * Тест поиска по полной фамилии без учета регистра
     */
    @Test
    public void whenFindBySurnameCaseSens() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("ArsenteV");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тест поиска по полному адресу без учета регистра
     */
    @Test
    public void whenFindByAddressCaseSens() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("BryANsk");
        assertThat(persons.iterator().next().getAddress(), is("Bryansk"));
    }
}