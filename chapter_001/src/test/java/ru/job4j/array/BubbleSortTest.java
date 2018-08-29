package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест программы сортировки массива пузырьком.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class BubbleSortTest {
    @Test
    public void whenArr5BubbleSort() {
        BubbleSort bub = new BubbleSort();
        int[] arr = new int[]{5, 1, 2, 7, 3};
        int[] expect = new int[]{1, 2, 3, 5, 7};
        assertThat(bub.sort(arr), is(expect));
    }
}