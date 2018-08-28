package ru.job4j.array;

/**
 * Программа перевертывания массива.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Turn {
    public int[] turn(int[] array) {
        int temp;
        for (int i = 0; i < (array.length / 2); i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}