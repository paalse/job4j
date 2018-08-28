package ru.job4j.array;

/**
 * Программа проверки содержимого массива.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean first = data[0];
        for (boolean element : data) {
            if (element != first) {
                result = false;
                break;
            }
        }
        return result;
    }
}