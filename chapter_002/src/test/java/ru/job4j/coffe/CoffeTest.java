package ru.job4j.coffe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import ru.job4j.coffe.CoffeMachine;

/**
 * Тесты расчета сдачи, кофе-машиной.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class CoffeTest {

    /**
     * Тест сдачи в 15 руб.
     */
    @Test
    public void changesTest15() {
        int[] result = {10, 5};
        CoffeMachine coffeMachine = new CoffeMachine();
        assertThat(coffeMachine.changes(50, 35), is(result));
    }

    /**
     * Тест сдачи в 28 руб.
     */
    @Test
    public void changesTest28() {
        int[] result = {10, 10, 5, 2, 1};
        CoffeMachine coffeMachine = new CoffeMachine();
        assertThat(coffeMachine.changes(50, 22), is(result));
    }

    /**
     * Тест сдачи в 29 руб.
     */
    @Test
    public void changesTest29() {
        int[] result = {10, 10, 5, 2, 2};
        CoffeMachine coffeMachine = new CoffeMachine();
        assertThat(coffeMachine.changes(50, 21), is(result));
    }

    /**
     * Тест когда нет сдачи
     */
    @Test
    public void changesTest0() {
        int[] result = {};
        CoffeMachine coffeMachine = new CoffeMachine();
        assertThat(coffeMachine.changes(50, 50), is(result));
    }
}
