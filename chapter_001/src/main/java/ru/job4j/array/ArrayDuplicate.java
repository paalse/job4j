package ru.job4j.array;

import java.util.Arrays;

/**
 * Программа удаления дубликатов в массиве.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int dup = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - dup;) {
                if (array[i].equals(array[j])) {
                    if (!array[array.length - dup - 1].equals(array[i])) {
                        array[j] = array[array.length - dup - 1];
                    }
                    dup++;
                } else {
                    j++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - dup);
    }
}