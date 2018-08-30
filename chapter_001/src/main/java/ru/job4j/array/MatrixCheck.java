package ru.job4j.array;

/**
 * Программа проверки элементов диагонали массива.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean first = data[0][0];
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != first) {
                result = false;
            }
        }
        return result;
    }
}