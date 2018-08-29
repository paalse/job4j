package ru.job4j.array;

/**
 * Программа проверки начала строки.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ArrayChar {
    private String data;

    public ArrayChar(String line) {
        this.data = line;
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        if (!this.data.startsWith(prefix)) {
            result = false;
        }
        return result;
    }
}