package ru.job4j.array;

/**
 * Программа объединения двух отсортированных по возрастанию массивов
 * с сохранением сортировки.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class UnionArray {
    public int[] union(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        for (int k = 0; k < arr3.length; k++) {
            if (i > arr1.length - 1) {
                arr3[k] = arr2[j];
                j++;
            } else if (j > arr2.length - 1) {
                arr3[k] = arr1[i];
                i++;
            } else if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
        }
        return arr3;
    }
}