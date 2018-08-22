package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculator тест.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class CalculatorTest {

    /**
     * Add test.
     */
    @Test
    public void whenAdd1Plus1Then2() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Subtract test.
     */
    @Test
    public void whenSubtract3Sub2Then1() {
        Calculator calc = new Calculator();
        calc.subtruct(3D, 2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Multiple test.
     */
    @Test
    public void whenMultiple4Mul2Then8() {
        Calculator calc = new Calculator();
        calc.multiple(4D, 2D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }

    /**
     * Div test.
     */
    @Test
    public void whenDiv4Div2Then2() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}