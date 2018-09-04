package ru.job4j.array;

import java.util.Arrays;

/**
 * Программа объединения массивов с сортировкой.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class UnionArray {
    public int[] union(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        Arrays.sort(result);
        return result;
    }
}