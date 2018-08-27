package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Программа тестирования поиска по массиву.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class FindLoopTest {
    /**
     * Тест при котором элемент находится.
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * Тест при котором элемент не находится.
     */
    @Test
    public void whenArrayHasLengh4ThenNot() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}