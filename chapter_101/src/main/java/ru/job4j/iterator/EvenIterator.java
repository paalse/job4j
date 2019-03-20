package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private final int[] values;
    private int index = 0;

    public EvenIterator(final int[] values) {
        this.values = values;
    }

    /**
     * Поиск индекса следующего четного числа
     *
     * @param startPos - стартовый индекс с которого производить поиск
     * @return - индекс следующего четного числа, если не найдено возвращает -1
     */
    public int evenFind(int startPos) {
        int result = -1;
        for (int i = startPos; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (index != -1 && evenFind(index) != -1) {
            result = true;
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (index == -1) {
            throw new NoSuchElementException();
        }

        int pos = index;
        if (pos == 0) {
            pos = evenFind(index);
        }
        Object result = values[pos];
        index = evenFind(pos + 1);
        return result;
    }
}