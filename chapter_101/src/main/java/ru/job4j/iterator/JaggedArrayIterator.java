package ru.job4j.iterator;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator {
    private final int[][] values;
    private int row = 0;
    private int index = 0;


    public JaggedArrayIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > row;
    }

    @Override
    public Object next() {
        Object result = values[row][index];
        if (index < values[row].length - 1) {
            index++;
        } else {
            row++;
            index = 0;
        }
        return result;
    }
}