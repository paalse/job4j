package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование шахматной доски.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class BoardTest {
    final String line = System.getProperty("line.separator");

    @Test
    public void when3x3() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void when5x4() {
        Board board = new Board();
        String result = board.paint(4, 5);
        String expected = String.format("x x %s x x%sx x %s x x%sx x %s", line, line, line, line, line);
        assertThat(result, is(expected));
    }
}