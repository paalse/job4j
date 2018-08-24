package ru.job4j.max;

/**
 * Программа вычисления максимального числа.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Max {
    /**
     * Сравнение двух чисел.
     *
     * @param first  - первое число
     * @param second - второе число
     * @return максимальное число
     */
    public int max(int first, int second) {
        return (first > second ? first : second);
    }
}
