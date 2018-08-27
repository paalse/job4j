package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Проверка заполнения массива степенями чисел.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class SquareTest {
    /**
     * Проверка на 3х элементах.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * Проверка на 4х элементах.
     */
    @Test
    public void whenBound4Then14916() {
        int bound = 4;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16};
        assertThat(rst, is(expect));
    }

    /**
     * Проверка на 1 элементе.
     */
    @Test
    public void whenBound1Then1() {
        int bound = 1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1};
        assertThat(rst, is(expect));
    }

    /**
     * Проверка на 0 элементах.
     */
    @Test
    public void whenBound0Then0() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{};
        assertThat(rst, is(expect));
    }
}