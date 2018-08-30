package ru.job4j.array;

/**
 * Программа проверки элементов диагонали массива.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        if (data.length > 2) {
            boolean first = data[0][0];
            for (int i = 0; i < data.length; i++) {
                if ((data[i][i] != first) || (data[i][data.length - i - 1] != first)) {
                    result = false;
                }
            }
        } else {
            if ((data[0][0] != data[1][1]) || (data[1][0] != data[0][1])) {
                result = false;
            }
        }

        return result;
    }
}