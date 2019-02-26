package ru.job4j.matrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест преобразования матрицы в List
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class MatrixTest {
    @Test
    public void matrixToListTest() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        Matrix my = new Matrix();
        List<Integer> result = my.convertMatrixToList(matrix);
        assertThat(result, is(expected));
    }
}