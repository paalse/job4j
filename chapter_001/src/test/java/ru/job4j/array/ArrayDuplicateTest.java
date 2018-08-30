package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест программы удаления дубликатов в массиве.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] origin = new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = new String[]{"Привет", "Мир", "Супер"};
        ArrayDuplicate arr = new ArrayDuplicate();
        assertThat(arr.remove(origin), is(expect));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithAllDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] value = new String[] {"Мир", "Мир", "Мир", "Мир", "Мир"};
        String[] expected = new String[] {"Мир"};
        String[] res = arrayDuplicate.remove(value);
        assertThat(res, is(expected));
    }
}