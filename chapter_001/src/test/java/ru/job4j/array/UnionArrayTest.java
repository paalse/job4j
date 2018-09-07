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
    public void test1() {
        int[] arr1 = new int[]{1, 3, 3, 5, 9, 10};
        int[] arr2 = new int[]{2, 3, 4, 7, 8};
        int[] expected = new int[]{1, 2, 3, 3, 3, 4, 5, 7, 8, 9, 10};
        UnionArray a = new UnionArray();
        int[] result = a.union(arr1, arr2);
        assertThat(result, is(expected));
    }

    @Test
    public void test2() {
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{4, 6};
        int[] expected = new int[]{4, 6};
        UnionArray a = new UnionArray();
        int[] result = a.union(arr1, arr2);
        assertThat(result, is(expected));
    }

    @Test
    public void test3() {
        int[] arr1 = new int[]{4, 6};
        int[] arr2 = new int[]{};
        int[] expected = new int[]{4, 6};
        UnionArray a = new UnionArray();
        int[] result = a.union(arr1, arr2);
        assertThat(result, is(expected));
    }
}
