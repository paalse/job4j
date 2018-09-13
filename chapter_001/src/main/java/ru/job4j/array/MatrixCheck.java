package ru.job4j.array;

/**
 * Программа проверки элементов диагонали массива.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if ((data[i][i] != data[0][0])
                    || (data[i][data.length - i - 1] != data[0][data.length - 1])) {
                result = false;
            }
        }
        return result;
    }
}