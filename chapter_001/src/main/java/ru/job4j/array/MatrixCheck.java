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
        boolean second = data[0][0];
        if ((data.length % 2) == 0) {
            second = data[0][data.length - 1];
        }
        for (int i = 0; i < data.length; i++) {
            if ((data[i][i] != first) || (data[i][data.length - i - 1] != second)) {
                result = false;
            }
        }
        return result;
    }
}