package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование преобразования списка в двухмерный массив.
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7),3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7ElementsThen7() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                7
        );
        int[][] expect = {{1}, {2}, {3}, {4}, {5}, {6}, {7}};
        assertThat(result, is(expect));
    }

    @Test
    public void when7ElementsThen10() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7),10);
        int[][] expect = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {0}, {0}, {0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when0ElementsThen3() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(),3);
        int[][] expect = {{}, {}, {}};
        assertThat(result, is(expect));
    }

    @Test
    public void when7ElementsThen0() {
        ConvertList2Array list = new ConvertList2Array();
        try {
            int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 0);
            Assert.fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}