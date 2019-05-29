package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test Args class
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ArgsTest {
    @Test
    public void argsTest() {
        String commandLine = "-d C:\\projects\\job4j\\chapter_003 -e java,html -o C:\\projects\\job4j\\my.zip";
        String origin = "C:\\projects\\job4j\\chapter_003 java html C:\\projects\\job4j\\my.zip";

        Args args = new Args(commandLine.split(" "));
        String result = args.directory();
        for (String item : args.exclude()) {
            result = result + " " + item;
        }
        result = result + " " + args.output();
        assertThat(result, is(origin));
    }
}