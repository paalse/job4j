package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование программы объединения массивов с сортировкой.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class UnionArrayTest {
    @Test
    public void whenUnion1() {
        int[] arr1 = new int[]{1, 2, 3, 5};
        int[] arr2 = new int[]{4, 6, 7, 8};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        UnionArray a = new UnionArray();
        int[] result = a.union(arr1, arr2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUnion2() {
        int[] arr1 = new int[]{1, 2, 3, 5};
        int[] arr2 = new int[]{2, 6, 7, 8};
        int[] expected = new int[]{1, 2, 2, 3, 5, 6, 7, 8};
        UnionArray a = new UnionArray();
        int[] result = a.union(arr1, arr2);
        assertThat(result, is(expected));
    }
}
