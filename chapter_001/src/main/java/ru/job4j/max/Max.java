package ru.job4j.max;

/**
 * Программа вычисления максимального числа.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Max {
    /**
     * Максимальное число из двух чисел.
     *
     * @param first  - первое число.
     * @param second - второе число.
     * @return максимальное число.
     */
    public int max(int first, int second) {
        return (first > second ? first : second);
    }

    /**
     * Максимальное число из трех чисел.
     *
     * @param first  - первое число.
     * @param second - второе число.
     * @param third  - третье число.
     * @return максимальное число.
     */
    public int max(int first, int second, int third) {
        return (max(max(first, second), third));
    }
}
