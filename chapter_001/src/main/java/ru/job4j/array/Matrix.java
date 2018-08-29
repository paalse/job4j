package ru.job4j.array;

/**
 * Программа заполнения таблицы умножения.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Matrix {
    public int[][] multiple(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (i + 1) * (j + 1);
            }
        }
        return arr;
    }
}