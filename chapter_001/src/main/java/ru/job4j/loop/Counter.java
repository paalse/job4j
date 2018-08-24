package ru.job4j.loop;

/**
 * Счетчик
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Counter {
    /**
     * Расчет суммы четных чисел из заданного дипазона.
     *
     * @param start  - начало диапазона.
     * @param finish - конец диапазона.
     * @return - сумма четных чисел.
     */
    public static int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result = result + i;
            }
        }
        return result;
    }
}