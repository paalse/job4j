package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты вывода геометрических фигур на консоль.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тест вывода на квадрата.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++++" + System.lineSeparator())
                                .append("+    +" + System.lineSeparator())
                                .append("+    +" + System.lineSeparator())
                                .append("++++++" + System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Тест вывода на треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   +   " + System.lineSeparator())
                                .append("  + +  " + System.lineSeparator())
                                .append(" +   + " + System.lineSeparator())
                                .append("+++++++" + System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}