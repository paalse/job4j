package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование программы вычисления максимального числа.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class MaxTest {
    /**
     * Проверка First<Second.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Проверка First>Second.
     */
    @Test
    public void whenSecondLessFirst() {
        Max maximum = new Max();
        int result = maximum.max(2, 1);
        assertThat(result, is(2));
    }

    /**
     * Проверка First=Second.
     */
    @Test
    public void whenFirstEqualSecond() {
        Max maximum = new Max();
        int result = maximum.max(2, 2);
        assertThat(result, is(2));
    }

    /**
     * Проверка поиска максимального числа из 3х чисел.
     */
    @Test
    public void whenMaxOnThreeNumb() {
        Max maximum = new Max();
        int result = maximum.max(4, 2, 3);
        assertThat(result, is(4));
    }
}

