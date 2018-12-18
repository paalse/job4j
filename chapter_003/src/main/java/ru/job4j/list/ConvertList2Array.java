package ru.job4j.list;

import java.util.List;

/**
 * Преобразования списка в двухмерный массив.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) throws NullPointerException {
        if (rows == 0) {
            throw new NullPointerException("Количество строк не может быть равным нулю !");
        }
        int cells = 0;
        if (list.size() % rows == 0) {
            cells = list.size() / rows;
        } else {
            cells = list.size() / rows + 1;
        }
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if ((i * cells + j) < list.size()) {
                    array[i][j] = list.get(i * cells + j);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}