package ru.job4j.matrix;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Преобразование матрицы в List
 *
 * @author Aleksey Pavlov (mailto:paalse@list.ru)
 */
public class Matrix {
    public List<Integer> convertMatrixToList(List<List<Integer>> matrix) {
        return matrix.stream()
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());
    }
}