package ru.job4j.tracker;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Aleksey Pavlov (paalse@list.ru)
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new ArrayList<String>(Arrays.asList("invalid", "1"))));
        input.ask("Enter", new ArrayList<Integer>() { { add(1); } });
        assertThat(this.mem.toString(), is(String.format("Пожалуйста введите корректное значение." + System.lineSeparator())));
    }
}