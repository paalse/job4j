package ru.job4j.loop;

/**
 * Программа расчета факториала.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Factorial {
    /**
     * Расчет факториала.
     *
     * @param n - число для  расчета.
     * @return - факториал.
     */
    public int calc(int n) {
        int result = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        }
        return result;
    }
}