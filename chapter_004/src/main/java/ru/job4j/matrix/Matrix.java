package ru.job4j.matrix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Преобразование матрицы в List
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Matrix {
    public List<Integer> convertMatrixToList(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(e -> Stream.of(e))
                .collect(Collectors.toList());
    }
}