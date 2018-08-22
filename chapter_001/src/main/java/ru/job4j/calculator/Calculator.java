package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Calculator {

    private double result;

    /**
     * Get result
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Add first and second param
     *
     * @param first  - first param
     * @param second - second param
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract first on second param.
     *
     * @param first  - first param
     * @param second - second param
     */
    public void subtruct(double first, double second) {
        this.result = first - second;
    }

    /**
     * Multiple first on second param.
     *
     * @param first  - first param
     * @param second - second param
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Div first on second param.
     *
     * @param first  - first param
     * @param second - second param
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
}