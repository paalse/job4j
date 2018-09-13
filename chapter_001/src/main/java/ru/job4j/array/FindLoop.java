package ru.job4j.array;

/**
 * Программа поиска по массиву.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class FindLoop {
    public int indexOf(int[] data, int element) {
        int result = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                result = i;
                break;
            }
        }
        return result;
    }
}